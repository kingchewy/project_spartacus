import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { map } from 'rxjs/operators'

const RESOURCE_URL = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

    constructor( private httpClient: HttpClient ) { }
    
    login (username: string, password: string) {
        return this.httpClient.post<any>(RESOURCE_URL, { username, password })
            .pipe(map(user => {
                // login successful if there's a user in the response
                if (user) {
                    // store user details and basic auth credentials in local storage 
                    // to keep user logged in between page refreshes
                    user.authdata = window.btoa(username + ':' + password)
                    localStorage.setItem('currentUser', JSON.stringify(user))
                }

                return user
            }))
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}
