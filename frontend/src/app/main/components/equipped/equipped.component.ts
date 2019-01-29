import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'curr-equipped',
  templateUrl: './equipped.component.html',
  styleUrls: ['./equipped.component.css']
})
export class EquippedComponent {
    private availableSlots
    private warning: String
    private shouldWarn = false
    
    private observe = this.characterService.character$.subscribe( char => {
        this.char = char
        this.equipped = char.equipped
        this.availableSlots = [1,2,3]
        this.equipped.forEach (()=> this.availableSlots.pop())
    })
    private char: Character
    private equipped: Item[]
    
  constructor( private characterService: CharacterService ) { }

    equip ( item: Item ) {
        let notYetSelected = this.equipped.every( selected => item != selected )
        
        if ( notYetSelected && this.equipped.length < 3 && item.minimumLvl <= this.char.lvl ){
            this.char.equipped.push(item)
//            this.characterService.setCharStats(item)
            this.characterService._character.next(this.char)
            
        } else if ( this.equipped.length >= 3 && item.minimumLvl ) {
            this.warning = "Only 3 Items equippable!"
            this.warn()
            
        } else if ( item.minimumLvl > this.char.lvl ) {
            this.warning = "Your Level is too low!"
            this.warn()
            
        } else if (!notYetSelected) {
            this.warn()
            this.warning = "Already selected"
        }
    }
    
    warn () {
        this.shouldWarn = true
            setTimeout ( () => {
                this.shouldWarn = false
            }, 2000)
    }
}
