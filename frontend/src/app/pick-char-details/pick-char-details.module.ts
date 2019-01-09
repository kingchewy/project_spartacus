import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PickCharDetailsRoutingModule } from './pick-char-details-routing.module';

@NgModule({
  declarations: [
      PickCharDetailsModule
  ],
  imports: [
    CommonModule,
    PickCharDetailsRoutingModule
  ]
})
export class PickCharDetailsModule { }
