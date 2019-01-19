import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainComponent } from './main.component'
import { DashboardComponent } from './dashboard/dashboard.component'
import { DialogComponent } from './shared/dialog/dialog.component'
import { CharDetailsComponent } from './char-details/char-details.component';
import { ShopComponent } from './shop/shop.component';
import { FightsHistoryComponent } from './fights-history/fights-history.component';
import { FightsSearchComponent } from './fights-search/fights-search.component';
import { FightsUpcomingComponent } from './fights-upcoming/fights-upcoming.component';

const routes: Routes = [
        { path: '', component: MainComponent,
        children: [
            { path: 'dashboard', component: DashboardComponent },
            { path: 'char-details', component: CharDetailsComponent },
            { path: 'shop', component: ShopComponent },
            { path: 'fights-history', component: FightsHistoryComponent },
            { path: 'fights-search', component: FightsSearchComponent },
            { path: 'fights-upcoming', component: FightsUpcomingComponent },
            { path: 'dialog/:race', component: DialogComponent }
                  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
