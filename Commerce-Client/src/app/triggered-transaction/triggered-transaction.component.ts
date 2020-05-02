import { Component, OnInit, NgModuleRef, Input} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Notification } from '../models/notification';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-triggered-transaction',
  templateUrl: './triggered-transaction.component.html',
  styleUrls: ['./triggered-transaction.component.css']
})

export class TriggeredTransactionComponent implements OnInit {

  @Input() public triggerId;
  @Input() public triggerName;
  @Input() public filters;
  notifications: Notification[];

  constructor(private notificationService: NotificationService, public activeModal: NgbActiveModal) {
  }

  ngOnInit(): void {
    this.getNotifications();
  }

  getNotifications() {
    this.notificationService.getNotifications(this.triggerId, this.filters).subscribe(notifications => {
      this.notifications = notifications;
    });
  }
}
