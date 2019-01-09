import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DialogComponent } from './dialog/dialog.component'
import { IntroComponent } from './intro/intro.component'
//import { PickCharacterComponent } from './pick-character/pick-character.component'
import { PickCharDetailsComponent } from './pick-char-details/pick-char-details.component'
import { DashboardComponent } from './dashboard/dashboard.component'

const routes: Routes = [
    { path: '', redirectTo: '/intro', pathMatch: 'full' },
    { path: 'intro', component: IntroComponent },
//    { path: 'pick-char', component: PickCharacterComponent },
    { path: 'pick-char', loadChildren: './pick-character/pick-character.module#PickCharacterModule'},
    //    { path: 'pick-char/:race', component: PickCharDetailsComponent },
    { path: 'dialog/:race', component: DialogComponent },
    { path: 'dashboard', component: DashboardComponent }

//  { path: '', redirectTo: '/dashboard'}

//  { path: 'login'}
//  { path: 'register'}
//  { path: 'reset-password'}
    
//  { path: 'intro'}
//  { path: 'dashboard', loadChildren}
//  { path: 'dashboard', loadChildren}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
