import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IntroComponent } from './auth/intro/intro.component'
import { RegisterComponent } from './auth/register/register.component'

const routes: Routes = [
    { path: '', redirectTo: '/intro', pathMatch: 'full' },
    { path: 'intro', component: IntroComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'pick-char', loadChildren: './character-create/pick-character/pick-character.module#PickCharacterModule'},
    { path: 'base', loadChildren: './main/main.module#MainModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
