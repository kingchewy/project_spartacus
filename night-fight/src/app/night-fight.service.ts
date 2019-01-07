import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

export class Account {
    id: number
    name: string
    eMail: string
    password: string
    blocked: number
    date: string
}

const ACCOUNTS_RESOURCE_URL = 'http://localhost:8080/news/resources/accounts'

@Injectable({
  providedIn: 'root',
})
export class NightFightService {

  constructor( private httpClient: HttpClient ) { }
    
    createAccount (account: Account): Promise<any> {
        return this.httpClient.post( ACCOUNTS_RESOURCE_URL, account ).toPromise()
    }
    
    retrieveAllAccounts (): Promise<any> {
        return this.httpClient.get<Account[]>(ACCOUNTS_RESOURCE_URL).toPromise()
    }
}
