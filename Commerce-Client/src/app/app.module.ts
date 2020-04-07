import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import appRoutes from './routerConfig';

import { TransactionsComponent } from './transactions/transactions.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { FormsModule } from '@angular/forms';
import { RuleComponent } from './rule/rule.component';
import { AmountComponent } from './amount/amount.component';
import { LocationComponent } from './location/location.component';
import { TimeComponent } from './time/time.component';
import { CategoryComponent } from './category/category.component';

@NgModule({
  declarations: [
    AppComponent,
    TransactionsComponent,
    LoginComponent,
    NavigationComponent,
    NotificationsComponent,
    RuleComponent,
    AmountComponent,
    LocationComponent,
    TimeComponent,
    CategoryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgbModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [RuleComponent]
})
export class AppModule { }
