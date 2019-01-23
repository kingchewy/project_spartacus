import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'curr-equipped',
  templateUrl: './equipped.component.html',
  styleUrls: ['./equipped.component.css']
})
export class EquippedComponent implements OnInit {
    
    private char = this.characterService.getCharacter().subscribe( x => {
        this.equipped = x.equipped
    })
    private equipped: Item[]
    
  constructor( private characterService: CharacterService ) { }

  ngOnInit() {
  }

}
