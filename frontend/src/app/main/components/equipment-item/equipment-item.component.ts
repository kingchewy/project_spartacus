import { Component, Input, OnInit } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'equipment-item',
  templateUrl: './equipment-item.component.html',
  styleUrls: ['./equipment-item.component.css']
})
export class EquipmentItemComponent implements OnInit {

    @Input() setting: string
    @Input() item: Item
    
    private selected = false
    private observe = this.characterService.character$.subscribe( char => {
        this.checkIfSelected(char)
        this.char = char
    })
    private char: Character

    constructor( private characterService: CharacterService ) { }
    
    ngOnInit () {
        this.checkIfSelected(this.char)
    }
    
    checkIfSelected ( char: Character ) {
        if ( this.item && (char.equippedItems.weaponPrimary == this.item ||
            char.equippedItems.weaponSecondary == this.item ||
            char.equippedItems.armor == this.item ||
            char.equippedItems.special == this.item) )
        {
            this.selected = true
        } else {
            this.selected = false
        }
    }
    
    arrangePopup (node, $event) {
        node.style.left = ( $event.clientX + 100 ) +"px"
    }
}
