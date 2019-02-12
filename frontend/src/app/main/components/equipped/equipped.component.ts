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
    private shouldWarn = false
    private warning: string
    
    private observe = this.characterService.character$.subscribe( char => this.char = char )
    private char: Character
    
  constructor( private characterService: CharacterService ) { }

    equip ( item: Item ) {
        switch ( item.type.toLowerCase() ) {
            case 'weapon':
                this.equipWeapon(item)
            break
            case 'armor':
                this.char.equippedItems.armor = item
            break
            case 'special':
                this.char.equippedItems.special = item
            break
        }
        this.characterService._character.next(this.char)
    }
    
    equipWeapon ( item: Item ) {
        let equipped = this.char.equippedItems
        
        if ( this.char.lvl >= item.minimumLvl ) {
            
            if ( item.twohanded ) {
                equipped.weaponPrimary = item
                equipped.weaponSecondary = null
                
            } else if ( !equipped.weaponPrimary ) {
                equipped.weaponPrimary = item
                
            } else if ( !equipped.weaponSecondary
                       && !equipped.weaponPrimary.twohanded
                       && equipped.weaponPrimary != item ) {
                equipped.weaponSecondary = item
                
            } else if ( equipped.weaponPrimary.twohanded ) {
                equipped.weaponPrimary = item
                
            } else if (equipped.weaponPrimary && equipped.weaponSecondary) {
                this.warn ( "Full" )
            }
        } else {
            this.warn( "Your Level is too low!" )
        }
    }
    
    warn ( warning ) {
        this.warning = warning
        this.shouldWarn = true
        setTimeout ( () => this.shouldWarn = false, 2000)
    }
}
