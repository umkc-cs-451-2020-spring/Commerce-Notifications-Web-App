import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { GlobalVariables } from '../common/global-variables';

export class Filters {
    userId = GlobalVariables.loggedInUserId;
    hasNotifications: boolean;
    startDate: NgbDate;
    endDate: NgbDate;
}