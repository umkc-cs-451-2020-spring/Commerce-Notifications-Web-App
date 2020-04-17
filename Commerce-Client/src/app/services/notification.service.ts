import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class NotificationService {
    // Endpoints
    private addRuleUrl = 'api/notifications/add';
    private getTriggersUrl = 'api/notifications/get/';

    constructor(private http: HttpClient) { }

    getTransactions(userId: number) {
        return this.http.get<any>(this.getTriggersUrl + userId + '/triggers');
    }
}
