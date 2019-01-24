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
    
    private observe = this.characterService.character$.subscribe( x => {
        this.char = x
        this.equipped = x.equipped
    })
    private char: Character
    private equipped: Item[]
    
  constructor( private characterService: CharacterService ) { }

    equip ( item: Item ) {
        let notYetSelected = this.equipped.every( selected => item != selected )
        
        if (notYetSelected && this.equipped.length <= 3){
            this.char.equipped.push(item)
            this.characterService.setCharStats(item)
            this.characterService._character.next(this.char)            
        }
    }
}
