import { Component, OnDestroy } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';

@Component({
  selector: 'app-char-details',
  templateUrl: './char-details.component.html',
  styleUrls: ['./char-details.component.css']
})
export class CharDetailsComponent implements OnDestroy {
    private observe = this.characterService.character$.subscribe( char => {
        this.char = char
    })
    private char: Character
    
    constructor( private characterService: CharacterService ) {
        document.body.setAttribute("class","background-char-details")
    }
    
    ngOnDestroy () {
        if (this.characterService.changesToSave) {
            console.log(this.char.equippedGear)
        }
    }
}
