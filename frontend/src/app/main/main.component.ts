import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../service/character.service';
import { RequestService } from '../service/request.service';
import { Character } from '../model/character';
import { Item } from '../model/item';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
    constructor( private characterService: CharacterService ,
                  private requestService: RequestService ) { }
    
    ngOnInit () {
        this.requestService.getPlayerCharacter().subscribe( char => {
            this.characterService._character.next(char)
            this.setColors(char.race)
        })
    }

    setColors (race) {
        document.documentElement.style
            .setProperty('--race-color', `var(--${race}-color)`)
                
        document.documentElement.style
            .setProperty('--race-color-t', `var(--${race}-color-t)`)
                
        document.documentElement.style
            .setProperty('--race-color-d', `var(--${race}-color-d)`)
    }
}
