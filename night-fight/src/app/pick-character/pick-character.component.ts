import { Component, OnInit } from '@angular/core';
import { Character } from '../character'

@Component({
  selector: 'pick-character',
  templateUrl: './pick-character.component.html',
  styleUrls: ['./pick-character.component.css']
})

export class PickCharacterComponent implements OnInit {
    private hiddenNodes = []
    private clickedChar : string
    
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
        this.hiddenNodes.forEach(val => val.style.display = "block")
    }
    
    pinChoice (): void {
        var confirmed = confirm(`Are you sure that you are a ${this.clickedChar}? You won't be able to undo this descicion!`)
        if (confirmed){
            document.getElementById("char-picker").style.opacity = "0"
            this.character.race = this.clickedChar
    
//            OpeningAnimation.setDialogCss()
//            
//            setTimeout(() => {
//                document.getElementById("char-picker").remove()
//                document.getElementById("create_new_char").style.display = "block"
//                Dialog.fillDialog("create_new_char", char.getAttribute("race"))
//            },1000)
        }
    }
    
    showCharDetails (that): void {
        this.clickedChar = that.id
        that.children[1].style.display = "block"
        that.classList.add("char-focus")
        
        let chars = document.getElementById("char-picker").children        
        this.hiddenNodes = []
        
        for (let val in chars){
            if (chars[val].nodeType == 1 && chars[val] != that){
                this.hiddenNodes.push(chars[val])
                chars[val].style.display = "none"
            }
        }
    }
}
//export clickedChar