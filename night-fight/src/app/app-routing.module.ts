import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DialogCreateComponent } from './dialog-create/dialog-create.component'

const routes: Routes = [
    { path: 'create-char', component: DialogCreateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
