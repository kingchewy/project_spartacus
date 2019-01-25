import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';

@Component({
  selector: 'attr-stats',
  templateUrl: './attr-stats.component.html',
  styleUrls: ['./attr-stats.component.css']
})
export class AttrStatsComponent {
    private observer = this.characterService.character$.subscribe( x => {
        this.char = x
    })
    private char: Character
    
  constructor( private characterService: CharacterService ) { }
}
