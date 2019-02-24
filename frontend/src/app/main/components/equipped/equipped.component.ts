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
        switch ( item.itemType.toLowerCase() ) {
            case 'weapon':
                this.equipWeapon(item)
            break
            case 'armor':
                this.char.equippedGear.armor = item
            break
            case 'special':
                this.char.equippedGear.special = item
            break
        }
        this.characterService._character.next(this.char)
    }
    
    equipWeapon ( item: Item ) {
        let equipped = this.char.equippedGear
        
        if ( this.char.lvl >= item.minLvl ) {
            
            if ( item.twoHanded ) {
                equipped.weaponPrimary = item
                equipped.weaponSecondary = null
                
            } else if ( !equipped.weaponPrimary ) {
                equipped.weaponPrimary = item
                
            } else if ( !equipped.weaponSecondary
                       && !equipped.weaponPrimary.twoHanded
                       && equipped.weaponPrimary != item ) {
                equipped.weaponSecondary = item
                
            } else if ( equipped.weaponPrimary.twoHanded ) {
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
