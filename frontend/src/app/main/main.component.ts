import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
    race = "monster"
  constructor() { }
    
    ngOnInit () {
        document.documentElement.style
    .setProperty('--race-color', `var(--${this.race}-color)`)
        
        document.documentElement.style
    .setProperty('--race-color-t', `var(--${this.race}-color-t)`)
        
        document.documentElement.style
    .setProperty('--race-color-d', `var(--${this.race}-color-d)`)
    }
}
