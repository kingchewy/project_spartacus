import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IntroComponent } from './intro/intro.component';
//import { PickCharacterComponent } from './pick-character/pick-character.component';
import { DialogComponent } from './dialog/dialog.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
//import { PickCharDetailsComponent } from './pick-char-details/pick-char-details.component';

@NgModule({
  declarations: [
    AppComponent,
    IntroComponent,
//    PickCharacterComponent,
    DialogComponent,
DashboardComponent,
NavBarComponent,
//    PickCharDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
