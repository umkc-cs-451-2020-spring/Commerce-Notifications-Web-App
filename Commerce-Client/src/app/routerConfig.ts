// routerConfig.ts

import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { TransactionsComponent } from './transactions/transactions.component';

const appRoutes: Routes = [
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent,
        pathMatch: 'full'
    },
    {
        path: 'notifications',
        component: NotificationsComponent
    },
    {
        path: 'transactions',
        component: TransactionsComponent
    }
];
export default appRoutes;
