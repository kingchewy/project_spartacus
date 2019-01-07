import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IntroComponent } from './intro/intro.component';
//import { PickCharacterComponent } from './pick-character/pick-character.component';
import { DialogComponent } from './dialog/dialog.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegisterComponent } from './register/register.component';
//import { PickCharDetailsComponent } from './pick-char-details/pick-char-details.component';
import { NightFightService } from './night-fight.service';

@NgModule({
  declarations: [
      AppComponent,
      IntroComponent,
//    PickCharacterComponent,
      DialogComponent,
      DashboardComponent,
      NavBarComponent,
      RegisterComponent,
//    PickCharDetailsComponent
  ],
  imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
