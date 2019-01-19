import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainComponent } from './main.component';
import { CharDetailsComponent } from './char-details/char-details.component';
import { ShopComponent } from './shop/shop.component';
import { FightsHistoryComponent } from './fights-history/fights-history.component';
import { FightsSearchComponent } from './fights-search/fights-search.component';
import { FightsUpcomingComponent } from './fights-upcoming/fights-upcoming.component';

import { DialogComponent } from './shared/dialog/dialog.component';
import { XpBarComponent } from './shared/xp-bar/xp-bar.component';
import { GearListBasicComponent } from './shared/gear-list-basic/gear-list-basic.component';
import { EquippedComponent } from './shared/equipped/equipped.component';
import { AttrStatsComponent } from './shared/attr-stats/attr-stats.component';

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
        XpBarComponent,
        GearListBasicComponent,
        EquippedComponent,
        AttrStatsComponent,
  ],
  imports: [
        CommonModule,
        MainRoutingModule,
  ]
})
export class MainModule { }
