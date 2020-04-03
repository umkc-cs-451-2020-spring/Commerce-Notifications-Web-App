import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class TransactionService {
    private testSpringUrl = 'api/transaction';

    constructor(private http: HttpClient) { }

    testSpring() {
        return this.http.get<any>(this.testSpringUrl);
    }
}
