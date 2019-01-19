import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

export class User {
    id: number
    name: string
    eMail: string
    password: string
    blocked: number
    date: String
}

const RESOURCE_URL = 'http://localhost:8080/night_fight'

@Injectable({
  providedIn: 'root',
})
export class NightFightService {

  constructor( private httpClient: HttpClient ) { }
    
    createAccount (account: User): Promise<any> {
        return this.httpClient.post( RESOURCE_URL + "/users", account ).toPromise()
    }
    
    retrieveAllAccounts (): Promise<any> {
        return this.httpClient.get<User[]>( RESOURCE_URL + "/users" ).toPromise()
    }
}
