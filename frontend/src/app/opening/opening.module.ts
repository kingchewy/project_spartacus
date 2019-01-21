import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { OpeningRoutingModule } from './opening-routing.module';
import { IntroComponent } from './intro/intro.component';
import { PickCharacterComponent } from './pick-character/pick-character.component';
import { PickCharDetailsComponent } from './pick-char-details/pick-char-details.component';
import { OpeningComponent } from './opening.component';

@NgModule({
  declarations: [
      IntroComponent,
      PickCharacterComponent,
      PickCharDetailsComponent,
      OpeningComponent
  ],
  imports: [
      CommonModule,
      OpeningRoutingModule,
      FormsModule
  ]
})
export class OpeningModule { }
