import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { User } from '../model/user';

const RESCOURCES = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})
export class RequestUserService {

    constructor(private httpClient: HttpClient) { }
    
    getThisUser(): Observable<User> {
        return this.httpClient.get<User>(RESCOURCES + '/users/1')
    }
}
