import { Component, OnInit, NgModuleRef } from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter, NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';
import { Trigger } from '../models/trigger';
import { Notification } from '../models/notification';
import { NotificationService } from '../services/notification.service';
import { GlobalVariables } from '../common/global-variables';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  triggers: Trigger[];
  notifications: Notification[];
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

  constructor(private notificationService: NotificationService,
              private calendar: NgbCalendar,
              public formatter: NgbDateParserFormatter,
              private modalService: NgbModal) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
   }

  ngOnInit(): void {
  }

  isUserLoggedIn() {
    return GlobalVariables.loggedInUserId !== undefined && GlobalVariables.loggedInUserId !== 0;
  }

  getRules() {
    if (this.isUserLoggedIn()) {
      this.notificationService.getRules(GlobalVariables.loggedInUserId).subscribe(trigger => {
        this.triggers = trigger;
      });
    }
  }

  openRule(triggerId: number, triggerName: string) {
    if (this.isUserLoggedIn()) {
      const modalRef = this.modalService.open(RuleComponent);
      modalRef.componentInstance.triggerId = triggerId;
      modalRef.componentInstance.triggerName = triggerName;
    }
  }

  deleteRule(triggerId: number, triggerName: string) {
    this.notificationService.deleteRule(triggerId, triggerName).subscribe(response => {
      console.log(response);
      this.getRules();
    });
  }

  // TODO Make new Modal for showing notifications
  getNotifications(triggerID: number) {
    this.notificationService.getNotifications(triggerID).subscribe(notifications => {
      this.notifications = notifications;
    });
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
