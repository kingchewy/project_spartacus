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
    
    private observe = this.characterService.character$.subscribe( x => {
        this.char = x
        this.equipped = x.equipped
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
            this.characterService.setCharStats(item)
            this.characterService._character.next(this.char)
            
        } else if ( this.equipped.length >= 3 && item.minimumLvl ) {
            this.warning = "Only 3 Items equippable!"
            console.log(this.warning)
            
        } else if ( item.minimumLvl > this.char.lvl ) {
            this.warning = "Your Level is too low!"
            console.log(this.warning)
            
        } else if (!notYetSelected) {
            console.log("Already selected")
        }
    }
}
