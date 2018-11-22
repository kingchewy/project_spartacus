import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DialogCreateComponent } from './dialog-create/dialog-create.component'
import { IntroComponent } from './intro/intro.component'

const routes: Routes = [
    { path: '', redirectTo: '/intro', pathMatch: 'full' },
    { path: 'intro', component: IntroComponent },
    { path: 'create-char/:race', component: DialogCreateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
