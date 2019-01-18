import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { MainComponent } from './main.component';
import { DialogComponent } from './dialog/dialog.component';
import { CharDetailsComponent } from './char-details/char-details.component';
import { ShopComponent } from './shop/shop.component';
import { FightsHistoryComponent } from './fights-history/fights-history.component';
import { FightsSearchComponent } from './fights-search/fights-search.component';
import { FightsUpcomingComponent } from './fights-upcoming/fights-upcoming.component';

@NgModule({
  declarations: [
        DashboardComponent,
        NavBarComponent,
        DialogComponent,
        MainComponent,
        CharDetailsComponent,
        ShopComponent,
        FightsHistoryComponent,
        FightsSearchComponent,
        FightsUpcomingComponent,
  ],
  imports: [
        CommonModule,
        MainRoutingModule,
  ]
})
export class MainModule { }
