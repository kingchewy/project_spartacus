import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap, shareReplay } from 'rxjs/operators';
import { environment } from '../../environments/environment';

import * as moment from "moment";
import { JwtHelperService } from '@auth0/angular-jwt';
import { Credentials } from './credentials';

const jwtHelper = new JwtHelperService();
const RESOURCE_URL = environment.baseUrl + "/authentication";

export class Token {
  accessToken: string;
  TokenType: string;
}


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  signup(){
    
  }

  login(credentials: Credentials):Promise<Token> {
    return this.http.post<Token>(RESOURCE_URL + '/signin', credentials).pipe(
      tap( authResult => this.setToken(authResult.accessToken)) )
      .toPromise();
  }
       

  logout() {
      localStorage.removeItem("jwt_token");
  }


  isTokenExpired(token?: string):boolean{
    if(!token) token = this.getToken();
    if(!token) return true;

    return jwtHelper.isTokenExpired(token);
  }

  private setToken(token):void{
    localStorage.setItem('jwt_token', token);
  }

  private getToken():string{
    return localStorage.getItem('jwt_token');
  }
}
