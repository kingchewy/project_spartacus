import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { CommonModule } from '@angular/common';

import { PickCharacterRoutingModule } from './pick-character-routing.module'
import { PickCharacterComponent } from './pick-character.component'
import { PickCharDetailsComponent } from '../pick-char-details/pick-char-details.component'

@NgModule({
  declarations: [
      PickCharacterComponent,
      PickCharDetailsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    PickCharacterRoutingModule
  ]
})
export class PickCharacterModule { }
