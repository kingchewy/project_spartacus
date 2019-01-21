import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IntroComponent } from './intro/intro.component';
import { PickCharacterComponent } from './pick-character/pick-character.component';
import { OpeningComponent } from './opening.component';

const routes: Routes = [
    { path: '', component: OpeningComponent,
        children: [
            { path: 'intro', component: IntroComponent },
            { path: 'intro/:newUser', component: IntroComponent },
            { path: 'pick-char', component: PickCharacterComponent }
        ]
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OpeningRoutingModule { }
