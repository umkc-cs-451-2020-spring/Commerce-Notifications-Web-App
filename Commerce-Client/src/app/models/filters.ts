import { GlobalVariables } from '../common/global-variables';

export class Filters {
    userId = GlobalVariables.loggedInUserId;
    hasNotifications: boolean;
    unread: boolean;
    startDate: string;
    endDate: string;
}
