import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';

import { JwtHelperService } from '@auth0/angular-jwt';
import { Credentials } from './credentials';
import { User } from '../model/user';

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

  signup(newUser: User):Promise<any>{
    return this.http.post(RESOURCE_URL + '/signup', newUser, {responseType: 'text'}).toPromise();
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
      console.log(jwtHelper.decodeToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGaWVzZSBMaWVzZSIsImlhdCI6MTU1MDA4NzI1OSwiZXhwIjoxNTUwMTczNjU5fQ.-GEdz3nvt1XiJpSKmJ4MdP81JdMED9-p_O6ScbWiCtiNaomEXbB026XIPpyd7y3cYSbgXxVNYePTgrtx_0bauA").sub)

    return jwtHelper.isTokenExpired(token);
  }

  private setToken(token):void{
    localStorage.setItem('jwt_token', token);
  }

  public getToken():string{
    return localStorage.getItem('jwt_token');
  }
}
