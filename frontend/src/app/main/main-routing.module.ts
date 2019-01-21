import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainComponent } from './main.component'
import { DashboardComponent } from './pages/dashboard/dashboard.component'
import { CharDetailsComponent } from './pages/char-details/char-details.component';
import { ShopComponent } from './pages/shop/shop.component';
import { FightsHistoryComponent } from './pages/fights-history/fights-history.component';
import { FightsSearchComponent } from './pages/fights-search/fights-search.component';
import { FightsUpcomingComponent } from './pages/fights-upcoming/fights-upcoming.component';

import { DialogComponent } from './components/dialog/dialog.component'

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
