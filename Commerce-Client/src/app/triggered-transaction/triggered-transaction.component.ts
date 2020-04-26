import { Component, OnInit, NgModuleRef, Input} from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter, NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';
import { Trigger } from '../models/trigger';
import { Notification } from '../models/notification';
import { NotificationService } from '../services/notification.service';
import { Transaction } from '../models/transaction';
import { NewTransactionComponent } from '../new-transaction/new-transaction.component';
import { TransactionService } from '../services/transaction.service';
import { GlobalVariables } from '../common/global-variables';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-triggered-transaction',
  templateUrl: './triggered-transaction.component.html',
  styleUrls: ['./triggered-transaction.component.css']
})
export class TriggeredTransactionComponent implements OnInit {
  @Input() public triggerId; 
  @Input() public triggerName; 
  notifications: Notification[];
  constructor(private notificationService: NotificationService, public activeModal: NgbActiveModal) { 
 
  }

  ngOnInit(): void {
    this.getNotifications();
  }
  getNotifications() {

    this.notificationService.getNotifications(this.triggerId).subscribe(notifications => {
      this.notifications = notifications;
    });
  }



}
