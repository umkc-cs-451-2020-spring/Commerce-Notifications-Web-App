import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Rule } from '../models/rule';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class NotificationService {
    // Endpoints
    private addRuleUrl = 'api/notifications/add';
    private getTriggersUrl = 'api/notifications/get';

    constructor(private http: HttpClient) { }

    getTriggers(userId: number) {
        const url = `${this.getTriggersUrl}/${userId}/triggers`;
        return this.http.get<any>(url);
    }

    addRule(rule: Rule) {
        return this.http.post<any>(this.addRuleUrl, rule);
    }
}
