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
            this.character.race = this.clickedChar
    
//            OpeningAnimation.setDialogCss()
//            setTimeout(() => {
//                document.getElementById("char-picker").remove()
//                document.getElementById("create_new_char").style.display = "block"
//                Dialog.fillDialog("create_new_char", char.getAttribute("race"))
//            },1000)
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