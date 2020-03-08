import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  model = {
    new: true, 
    amount: true,
    time: true,
    location: true
  };
  constructor() { }

  ngOnInit(): void {
  }

}
