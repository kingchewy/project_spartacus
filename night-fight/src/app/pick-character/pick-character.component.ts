import { Component, OnInit } from '@angular/core';
import { Character } from '../character'

@Component({
  selector: 'pick-character',
  templateUrl: './pick-character.component.html',
  styleUrls: ['./pick-character.component.css']
})

export class PickCharacterComponent implements OnInit {
    private clickedChar : string
    private showDetails = false
    private returnOv = false
    
    character : Character = {
        equipped: [],
        id: 1,
        lvl: 1,
        name: "",
        ownedGear: [],
        playerID: 1,
        race: ""
    }
    
    constructor () { }
    ngOnInit () { }
    
    returnToOverview (): void {
        this.showDetails = false
        this.clickedChar = undefined
        this.returnOv = true
    }
    
    pinChoice (): void {
        let confirmed = confirm(`Are you sure that you are a ${this.clickedChar}? You won't be able to undo this descicion!`)
        if (confirmed){
            document.getElementById("char-picker").style.opacity = "0"
            document.getElementById("picked-flash").style.display = "block"
            this.character.race = this.clickedChar
        }
    }
    
    showCharDetails (that): void {
        if (!this.returnOv && !this.showDetails){
            this.clickedChar = that.id
            this.showDetails = true
        } else {
            this.returnOv = false
        }
    }
}