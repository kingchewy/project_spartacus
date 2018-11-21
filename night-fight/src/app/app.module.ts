import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IntroComponent } from './intro/intro.component';
import { PickCharacterComponent } from './pick-character/pick-character.component';
import { DialogCreateComponent } from './dialog-create/dialog-create.component';

@NgModule({
  declarations: [
    AppComponent,
    IntroComponent,
    PickCharacterComponent,
    DialogCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
