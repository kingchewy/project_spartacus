import { Component, Input, EventEmitter, Output } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'gear-list-basic',
  templateUrl: './gear-list-basic.component.html',
  styleUrls: ['./gear-list-basic.component.css']
})
export class GearListBasicComponent {

    @Input() setting: string    
    @Output() private add = new EventEmitter<Item>()
    
    private observe = this.characterService.character$.subscribe( x => {
        this.char = x
    })
    private char: Character
    
  constructor( private characterService: CharacterService ) { }
}
