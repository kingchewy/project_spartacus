import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanActivateChild } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild {
  
  constructor(
    private router: Router,
    private authService: AuthService
    ){}
    
    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
//      console.log("CanActivate Guard Method");

      if(!this.authService.isTokenExpired()){
//        console.log("token valid")
        return true;
      } 
//      console.log("token expired: ", this.authService.getToken())
      // not logged in so redirect to login page with the return url
      this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
      return false;
    }


    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
//      console.log("CanActivateChild Guard Method");
      if(!this.authService.isTokenExpired()){
//        console.log("token valid")
        return true;
      } 
//      console.log("token expired: ", this.authService.getToken())
      // not logged in so redirect to login page with the return url
//      console.log("state url: ", state.url)
      this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
      return false;
    }

}
    