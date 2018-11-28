import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Character } from '../character'
import { Stats } from '../stats'

@Component({
  selector: 'pick-character',
  templateUrl: './pick-character.component.html',
  styleUrls: ['./pick-character.component.css']
})

export class PickCharacterComponent {
    private clickedRace : string
    private showDetails = false
    private returnOv = false
    private charName = "Your Fighter"
    private char: Character = {
        id: 0,
        playerID: 0,
        name: "",
        race: "",
        lvl: 0,
        stats: {hp: 1,
                armor: 1,
                strength: 1,
                accuracy: 1,
                criticalhitchance: 1,
                agility: 1},
        ownedGear: [],
        equipped: []
    }
    
    constructor (private router: Router) { }
    
    returnToOverview () {
        this.showDetails = false
        this.clickedRace = undefined
        this.returnOv = true
    }
    
    pinChoice () {
        let confirmed = confirm(`Are you sure that you are a ${this.clickedRace} called\n\n${this.charName}?\n\nYou won't be able to undo this descicion!`)
        if (confirmed){
            this.char.name = this.charName
            this.char.race = this.clickedRace
            console.log(this.char)
            
            document.getElementById("char-picker").style.opacity = "0"
            this.router.navigateByUrl("/dialog/" + this.clickedRace)
        }
    }
    
    showCharDetails (that) {
        if (!this.returnOv && !this.showDetails){
            this.clickedRace = that.id
            this.showDetails = true
        } else {
            this.returnOv = false
        }
    }
}