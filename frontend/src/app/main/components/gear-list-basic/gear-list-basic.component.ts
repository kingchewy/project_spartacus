import { Component, OnInit, Input } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'gear-list-basic',
  templateUrl: './gear-list-basic.component.html',
  styleUrls: ['./gear-list-basic.component.css']
})
export class GearListBasicComponent implements OnInit {

    @Input() setting: string
    
    private char = this.characterService.getCharacter().subscribe( x => {
        this.allGear = x.ownedGear
        console.log(x.ownedGear)
    })
    private allGear: Item[]
    
  constructor( private characterService: CharacterService ) { }

  ngOnInit() {
  }

}
