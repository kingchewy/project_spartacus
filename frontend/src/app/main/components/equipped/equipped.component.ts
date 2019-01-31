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
    
//    equip ( item: Item ) {
//        let notYetSelected = this.equippedItems.every( selected => item != selected )
//        
//        if ( notYetSelected && this.equippedItems.length < 3 && item.minimumLvl <= this.char.lvl ){
////            this.char.equippedItems.push(item)
//            this.characterService._character.next(this.char)
//            
//        } else if ( this.equippedItems.length >= 3 && item.minimumLvl ) {
//            this.warning = "Only 3 Items equippable!"
//            this.warn()
//            
//        } else if ( item.minimumLvl > this.char.lvl ) {
//            this.warning = "Your Level is too low!"
//            this.warn()
//            
//        } else if ( !notYetSelected ) {
//            this.warn()
//            this.warning = "Already selected"
//        }
//    }
    equipWeapon ( item: Item ) {
        if ( this.char.lvl >= item.minimumLvl ) {

            if ( item.twohanded ) {
                this.char.equippedItems.weaponPrimary = item
                this.char.equippedItems.weaponSecondary = null
                
            } else if ( !this.char.equippedItems.weaponPrimary ) {
                this.char.equippedItems.weaponPrimary = item
                
            } else if ( !this.char.equippedItems.weaponSecondary
                       && !this.char.equippedItems.weaponPrimary.twohanded
                       && this.char.equippedItems.weaponPrimary != item ) {
                this.char.equippedItems.weaponSecondary = item
                
            } else if ( this.char.equippedItems.weaponPrimary.twohanded || this.char.equippedItems.weaponSecondary.twohanded ) {
                this.char.equippedItems.weaponPrimary = item
            }
        } else {
            this.warning = "Your Level is too low!"
            this.warn()
        }
    }
    
    
    warn () {
        this.shouldWarn = true
            setTimeout ( () => {
                this.shouldWarn = false
            }, 2000)
    }
}
