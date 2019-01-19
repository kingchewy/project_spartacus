import { Component } from '@angular/core';

@Component({
  selector: 'xp-bar',
  templateUrl: './xp-bar.component.html',
  styleUrls: ['./xp-bar.component.css']
})
export class XpBarComponent {

    currentXP = 10
    prevLvlXP = 8
    nextLvlXP = 15
    prevLvl = 2
    nextLvl = 3
    
  constructor() { }

    
}
