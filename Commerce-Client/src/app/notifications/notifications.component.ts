import { Component, OnInit } from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';
import { Trigger } from '../models/trigger';
import { Notification } from '../models/notification';
import { Filters } from '../models/filters';
import { NotificationService } from '../services/notification.service';
import { GlobalVariables } from '../common/global-variables';
import { TriggeredTransactionComponent } from '../triggered-transaction/triggered-transaction.component';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  filters: Filters;
  triggers: Trigger[];
  notifications: Notification[];

  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;

  constructor(private notificationService: NotificationService,
              private calendar: NgbCalendar,
              public formatter: NgbDateParserFormatter,
              private modalService: NgbModal) {
    this.filters = new Filters();
    this.filters.hasNotifications = false;
    this.fromDate = null;
    this.toDate = null;
    this.filters.startDate = this.dateToString(this.fromDate);
    this.filters.endDate = this.dateToString(this.toDate);
   }

  ngOnInit(): void {
  }

  isUserLoggedIn() {
    return GlobalVariables.loggedInUserId !== undefined && GlobalVariables.loggedInUserId !== 0;
  }

  resetFilters() {
    this.filters = new Filters();
    this.filters.hasNotifications = false;
    this.fromDate = null;
    this.toDate = null;
    this.filters.startDate = this.dateToString(this.fromDate);
    this.filters.endDate = this.dateToString(this.toDate);
    this.triggers = [];
  }

  getRules() {
    if (this.isUserLoggedIn()) {
      this.notificationService.getRules(this.filters).subscribe(trigger => {
        this.triggers = trigger;
      });
    }
  }

  openRule(triggerId: number, triggerName: string) {
    if (this.isUserLoggedIn()) {
      const modalRef = this.modalService.open(RuleComponent);
      modalRef.componentInstance.triggerId = triggerId;
      modalRef.componentInstance.triggerName = triggerName;
      modalRef.result.then(() => { this.getRules(); }, () => { console.log('Backdrop click'); });
    }
  }

  deleteRule(triggerId: number, triggerName: string) {
    this.notificationService.deleteRule(triggerId, triggerName).subscribe(response => {
      console.log(response);
      this.getRules();
    });
  }

  getNotifications(triggerID: number, triggerName: string) {
    const modalRef = this.modalService.open(TriggeredTransactionComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.triggerId = triggerID;
    modalRef.componentInstance.triggerName = triggerName;
    modalRef.componentInstance.filters = this.filters;
  }

  export() {
    if (this.isUserLoggedIn()) {
      let ws: XLSX.WorkSheet;
      let wsName: string;
      const wb: XLSX.WorkBook = XLSX.utils.book_new();

      this.notificationService.getAllNotifications(this.filters).subscribe(notifications => {
        ws = XLSX.utils.json_to_sheet(notifications);
        wsName = GlobalVariables.loggedInUsername + '\'s Notifications';
        XLSX.utils.book_append_sheet(wb, ws, wsName);
        XLSX.writeFile(wb, wsName + '.xlsx');
      });
    }
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
    this.filters.startDate = this.dateToString(this.fromDate);
    this.filters.endDate = this.dateToString(this.toDate);
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

  dateToString(date: NgbDate): string {
    return date !== undefined && date !== null ? date.year + '-' + date.month + '-' + date.day : '';
  }

}
