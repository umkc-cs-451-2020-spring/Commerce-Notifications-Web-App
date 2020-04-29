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
  public isCollapsed = false;

  hoveredDate: NgbDate;

  constructor(private notificationService: NotificationService,
              private calendar: NgbCalendar,
              public formatter: NgbDateParserFormatter,
              private modalService: NgbModal) {
    this.filters = new Filters();
    this.filters.startDate = calendar.getToday();
    this.filters.endDate = calendar.getNext(calendar.getToday(), 'd', 10);

   }

  ngOnInit(): void {
  }

  isUserLoggedIn() {
    return GlobalVariables.loggedInUserId !== undefined && GlobalVariables.loggedInUserId !== 0;
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
      modalRef.componentInstance.filters = this.filters;
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
  }

  export() {
    if (this.isUserLoggedIn()) {
      let ws: XLSX.WorkSheet;
      let wsName: string;
      const wb: XLSX.WorkBook = XLSX.utils.book_new();

      this.notificationService.getAllNotifications(GlobalVariables.loggedInUserId).subscribe(notifications => {
        ws = XLSX.utils.json_to_sheet(notifications);
        wsName = GlobalVariables.loggedInUsername + '\'s Notifications';
        XLSX.utils.book_append_sheet(wb, ws, wsName);
        XLSX.writeFile(wb, wsName + '.xlsx');
      });
    }
  }

  onDateSelection(date: NgbDate) {
    if (!this.filters.startDate && !this.filters.endDate) {
      this.filters.startDate = date;
    } else if (this.filters.startDate && !this.filters.endDate && date.after(this.filters.startDate)) {
      this.filters.endDate = date;
    } else {
      this.filters.endDate = null;
      this.filters.startDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.filters.startDate && !this.filters.endDate && this.hoveredDate
      && date.after(this.filters.startDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.filters.startDate) && date.before(this.filters.endDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.filters.startDate) || date.equals(this.filters.endDate) || this.isInside(date) || this.isHovered(date);
  }

  validateInput(currentValue: NgbDate, input: string): NgbDate {
    const parsed = this.formatter.parse(input);
    return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
  }

}
