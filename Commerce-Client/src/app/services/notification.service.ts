import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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
    private editRuleUrl = 'api/notifications/edit';
    private deleteRuleUrl = 'api/notifications/delete';
    private getRulesUrl = 'api/notifications/get';

    constructor(private http: HttpClient) { }

    getRules(userId: number) {
        const url = `${this.getRulesUrl}/${userId}/rules`;
        return this.http.get<any>(url);
    }

    addRule(rule: Rule) {
        return this.http.post<any>(this.addRuleUrl, rule);
    }

    editRule(rule: Rule) {
        return this.http.post<any>(this.editRuleUrl, rule);
    }

    deleteRule(triggerId: number, triggerName: string) {
        const params = new HttpParams()
            .set('triggerId', triggerId.toString())
            .set('triggerName', triggerName);
        return this.http.delete<any>(this.deleteRuleUrl, {params});
    }
}
