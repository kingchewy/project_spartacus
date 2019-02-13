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
                this.char.equippedGear.itemArmor = item
            break
            case 'special':
                this.char.equippedGear.itemSpecial = item
            break
        }
        this.characterService._character.next(this.char)
    }
    
    equipWeapon ( item: Item ) {
        let equipped = this.char.equippedGear
        
        if ( this.char.lvl >= item.minimumLvl ) {
            
            if ( item.twohanded ) {
                equipped.itemWeaponPrimary = item
                equipped.itemWeaponSecondary = null
                
            } else if ( !equipped.itemWeaponPrimary ) {
                equipped.itemWeaponPrimary = item
                
            } else if ( !equipped.itemWeaponSecondary
                       && !equipped.itemWeaponPrimary.twohanded
                       && equipped.itemWeaponPrimary != item ) {
                equipped.itemWeaponSecondary = item
                
            } else if ( equipped.itemWeaponPrimary.twohanded ) {
                equipped.itemWeaponPrimary = item
                
            } else if (equipped.itemWeaponPrimary && equipped.itemWeaponSecondary) {
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
