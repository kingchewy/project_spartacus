import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DialogComponent } from './dialog/dialog.component'
import { IntroComponent } from './intro/intro.component'
import { PickCharacterComponent } from './pick-character/pick-character.component'

const routes: Routes = [
    { path: '', redirectTo: '/intro', pathMatch: 'full' },
    { path: 'intro', component: IntroComponent },
    { path: 'char-picker', component: PickCharacterComponent },
    { path: 'char-picker/:race', component: PickCharacterComponent },
    { path: 'dialog/:race', component: DialogComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
