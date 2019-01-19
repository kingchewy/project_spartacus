import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'
import { PickCharDetailsComponent } from './pick-char-details.component'

const routes: Routes = [
    { path: '', component: PickCharDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PickCharDetailsRoutingModule { }
