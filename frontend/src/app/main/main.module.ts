import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { MainComponent } from './main.component';
import { CharDetailsComponent } from './pages/char-details/char-details.component';
import { ShopComponent } from './pages/shop/shop.component';
import { FightsHistoryComponent } from './pages/fights-history/fights-history.component';
import { FightsSearchComponent } from './pages/fights-search/fights-search.component';
import { FightsUpcomingComponent } from './pages/fights-upcoming/fights-upcoming.component';

import { DialogComponent } from './components/dialog/dialog.component';
import { XpBarComponent } from './components/xp-bar/xp-bar.component';
import { GearListBasicComponent } from './components/gear-list-basic/gear-list-basic.component';
import { EquippedComponent } from './components/equipped/equipped.component';
import { AttrStatsComponent } from './components/attr-stats/attr-stats.component';
import { ItemComponent } from './components/item/item.component';
import { ShopSelectetItemComponent } from './components/shop-selectet-item/shop-selectet-item.component';
import { SearchOverviewComponent } from './components/search-overview/search-overview.component';

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
        ItemComponent,
        ShopSelectetItemComponent,
        SearchOverviewComponent
  ],
  imports: [
        CommonModule,
        MainRoutingModule
  ]
})
export class MainModule { }
