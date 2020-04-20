import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Transaction } from '../models/Transaction';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class TransactionService {
    // Endpoints
    private addTransactionsUrl = 'api/transactions/add'; 
    private testSpringUrl = 'api/transactions/test';
    private getTransactionsUrl = 'api/transactions/';

    constructor(private http: HttpClient) { }

    testSpring() {
        return this.http.get<any>(this.testSpringUrl);
    }

    getTransactions(userId: number) {
        return this.http.get<any>(this.getTransactionsUrl + userId);
    }

    addNewTransaction(newTransaction: Transaction) {
        return this.http.post<any>(this.addTransactionsUrl, newTransaction);
    }
}
