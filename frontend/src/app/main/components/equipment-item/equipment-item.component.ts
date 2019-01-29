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
    
    private selected: boolean
    private observe = this.characterService.character$.subscribe( char => {
        this.checkIfSelected (char)
        this.char = char
    })
    private char: Character

  constructor( private characterService: CharacterService ) { }
    
    ngOnInit () {
        this.checkIfSelected(this.char)
    }
    
    checkIfSelected (char$) {
        if (this.item) {
            let found = char$.equipped.
            filter( item => {
                return item == this.item
            })

            if (found.length) {
                this.selected = true
            } else {
                this.selected = false
            }
        }
    }
}
