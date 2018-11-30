import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PickCharacterComponent } from './pick-character.component'
import { PickCharDetailsComponent } from '../pick-char-details/pick-char-details.component'

const routes: Routes = [
    { path: '', component: PickCharacterComponent,
//        children: [{ path: ':race', loadChildren: '../pick-char-details/pick-char-details.module#PickCharDetailsModule' }]
        children: [{ path: ':race', component: PickCharDetailsComponent}]
    },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PickCharacterRoutingModule { }
