import { Component, Input, OnInit } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'equipment-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

    @Input() setting: string
    @Input() item: Item
    @Input() forceSelected: boolean
    
    private selected = false
    private observe = this.characterService.character$.subscribe( char => {
        this.char = char
        this.checkIfSelected(char)
    })
    private char: Character

    constructor( private characterService: CharacterService ) { }
    
    ngOnInit () {
//        this.checkIfSelected(this.char)
    }
    
    checkIfSelected ( char: Character ) {
        if ( this.item && (char.equippedGear.itemWeaponPrimary == this.item ||
            char.equippedGear.itemWeaponSecondary == this.item ||
            char.equippedGear.itemArmor == this.item ||
            char.equippedGear.itemSpecial == this.item) )
        {
            this.selected = true
        } else {
            this.selected = false
        }
    }
    
    arrangePopup (node, $event) {
        node.style.left = ( $event.clientX + 60 ) +"px"
    }
}
