import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IntroComponent } from './auth/intro/intro.component'
import { RegisterComponent } from './auth/register/register.component'
import { LoginComponent } from './auth/login/login.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
    { path: '', redirectTo: '/intro', pathMatch: 'full' },
    { path: 'intro', component: IntroComponent },
    { path: 'intro/:newUser', component: IntroComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'pick-char', loadChildren: './character-create/pick-character/pick-character.module#PickCharacterModule'},
    { 
      path: 'base',
      loadChildren: './main/main.module#MainModule',
      canActivate: [AuthGuard],
      canActivateChild: [AuthGuard]
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
