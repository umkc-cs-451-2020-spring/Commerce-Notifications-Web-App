import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class TransactionService {
    // Endpoints
    private testSpringUrl = 'api/transactions/test';
    private getTransactionsUrl = 'api/transactions/';

    constructor(private http: HttpClient) { }

    testSpring() {
        return this.http.get<any>(this.testSpringUrl);
    }

    getTransactions(userId: number) {
        return this.http.get<any>(this.getTransactionsUrl + userId);
    }
}
