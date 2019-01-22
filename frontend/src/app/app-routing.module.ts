import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IntroComponent } from './opening/intro/intro.component'
import { RegisterComponent } from './auth/register/register.component'
import { LoginComponent } from './auth/login/login.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
    { path: '', redirectTo: '/opening/intro', pathMatch: 'full' },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { 
      path: 'base',
      loadChildren: './main/main.module#MainModule',
      canActivate: [AuthGuard],
      canActivateChild: [AuthGuard]
    },
    { 
      path: 'opening',
      loadChildren: './opening/opening.module#OpeningModule',
      canActivate: [AuthGuard],
      canActivateChild: [AuthGuard]
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
