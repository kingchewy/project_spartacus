import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';

@Component({
  selector: 'app-char-details',
  templateUrl: './char-details.component.html',
  styleUrls: ['./char-details.component.css']
})
export class CharDetailsComponent {
    private char = this.characterService.character$.subscribe( char => {
        this.name = char.name
    })
    private name: string
    
  constructor( private characterService: CharacterService ) { }

}
