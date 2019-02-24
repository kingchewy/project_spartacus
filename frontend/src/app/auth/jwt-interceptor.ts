import { Injectable } from '@angular/core';
//import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { HttpInterceptor, HttpSentEvent, HttpHeaderResponse, HttpHandler, HttpEvent, HttpRequest, HttpHeaders, HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    
    constructor(private authService: AuthService) {
       // console.log("jwt intercept")
     }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let token = this.authService.getToken();
        if(token){
//            console.log("jwt intercept. TOKEN = ",token)
            request = request.clone({
                setHeaders : { 
                    Authorization: `Bearer ${token}`
                }
            });
        }

//        console.log("request: ",request.headers.getAll)
        return next.handle(request);
    }
}