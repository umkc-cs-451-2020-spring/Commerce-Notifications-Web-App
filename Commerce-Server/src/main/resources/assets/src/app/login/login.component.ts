import { Component, OnInit } from '@angular/core';
import { Credentials } from '../models/credentials';
import { LoginService } from '../services/login.service';
import { GlobalVariables } from '../common/global-variables';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = new Credentials();
  message: string;
  userId: number;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.message = '';
    if (this.credentials.username === undefined || this.credentials.username === '') {
      this.message += 'Must enter a Username.';
    }
    if (this.credentials.password === undefined || this.credentials.password === '') {
      this.message += 'Must enter a Password.';
    }
    if (this.message === undefined || this.message === '') {
      this.loginService.login(this.credentials).subscribe(user => {
        this.credentials = user;
        if (this.credentials.userID !== 0 && this.credentials.username !== '') {
          GlobalVariables.loggedInUserId = this.credentials.userID;
          GlobalVariables.loggedInUsername = this.credentials.username;
          this.router.navigateByUrl('/notifications');
        } else {
          this.message = 'Incorrect Username or Password.';
        }
      });
    }
  }

}
