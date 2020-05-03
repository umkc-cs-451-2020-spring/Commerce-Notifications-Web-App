import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Credentials } from '../models/credentials';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
};

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    // Endpoints
    private loginUrl = 'api/user/login';

    constructor(private http: HttpClient) { }

    login(credentials: Credentials) {
        return this.http.post<any>(this.loginUrl, credentials);
    }
}
