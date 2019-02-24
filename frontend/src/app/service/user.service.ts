import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    user: User = {
        name: "",
        username: "",
        email: "",
        password: ""
    }
    
    _user: BehaviorSubject<User> = new BehaviorSubject<User>(this.user)
    readonly user$: Observable<User> = this._user.asObservable()
    
    constructor() { 
        this.user$.subscribe( user => this.user = user )
    }
}
