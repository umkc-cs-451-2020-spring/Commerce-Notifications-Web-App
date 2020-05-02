import { Component, OnInit } from '@angular/core';
import { GlobalVariables } from '../common/global-variables';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  isUserLoggedIn() {
    return GlobalVariables.loggedInUserId !== undefined && GlobalVariables.loggedInUserId !== 0;
  }

  logout() {
    GlobalVariables.loggedInUserId = 0;
    GlobalVariables.loggedInUsername = '';
  }

}
