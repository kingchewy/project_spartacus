import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'pick-character',
  templateUrl: './pick-character.component.html',
  styleUrls: ['./pick-character.component.css']
})

export class PickCharacterComponent {
    clickedRace : string
    showDetails = false

    constructor (private router: Router) { }

    showCharDetails (that) {
        if (!this.showDetails){
            this.clickedRace = that.id
            this.showDetails = true
        }
        this.router.navigateByUrl("/pick-char/" + this.clickedRace)
    }
}