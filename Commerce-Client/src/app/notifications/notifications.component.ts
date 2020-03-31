import { Component, OnInit } from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter, NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { TransactionsComponent } from '../transactions/transactions.component';
import { RuleComponent } from '../rule/rule.component';

interface Notification {
  name: string;
  notificationCount: number;
}

const NOTIFICATIONS: Notification[] = [
  {name: 'Transaction amount over $500', notificationCount: 4},
  {name: 'Transaction from out of state', notificationCount: 1},
  {name: 'Duplicate Transactions', notificationCount: 2},
  {name: 'Transaction occured between 2:00 am and 6:00 am', notificationCount: 0},
];
@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  notifications = NOTIFICATIONS;
  public isCollapsed = false;
  model = {
    new: true,
    amount: true,
    time: true,
    location: true,
    duplicates: true,
    notTriggered: true
  };

  hoveredDate: NgbDate;

  fromDate: NgbDate;
  toDate: NgbDate;

  constructor(private calendar: NgbCalendar, public formatter: NgbDateParserFormatter, private modalService: NgbModal) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
   }

  ngOnInit(): void {
  }

  openRule() {
    const modalRef = this.modalService.open(RuleComponent);
    modalRef.componentInstance.name = 'World';
  }

  openTransactions(notification: Notification) {
    const modalRef = this.modalService.open(TransactionsComponent, { windowClass:"transactions-modal" });
  }

  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || date.equals(this.toDate) || this.isInside(date) || this.isHovered(date);
  }

  validateInput(currentValue: NgbDate, input: string): NgbDate {
    const parsed = this.formatter.parse(input);
    return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
  }

}
