import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../service/character.service';
import { Character } from '../model/character';
import { Item } from '../model/item';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
    private char = this.characterService.getCharacter().subscribe( x => {
        this.race = x.race
    })
    private race : string
  
//    item1: Item = {
//        id : 1,
//        name : "Lanze",
//        price : 321,
//        type : "weapon",
//        characterId : 3,
//        minimumLvl : 4,
//        damage : 120,
//        accuracy : 0.6,
//        critDamage : 3,
//        armor : 0,
//        agility : 0
//    }
//    item3: Item = {
//        id : 3,
//        name : "Harpune",
//        price : 123,
//        type : "weapon",
//        characterId : 3,
//        minimumLvl : 4,
//        damage : 1000,
//        accuracy : 0.6,
//        critDamage : 3,
//        armor : 0,
//        agility : 0
//    }
//    item2: Item = {
//        id : 2,
//        name : "flipflops",
//        price : 666,
//        type : "armor",
//        characterId : 3,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    char2: Character = {
//        id : 1,
//        name : "Green Bean",
//        race : "human",
//        playerID : 1,
//        lvl : 5,
//        hp : 800,
//        strength : 6,
//        armor : 3,
//        accuracy : 2,
//        agility : 5,
//        criticalhitchance : 0.25,
//        ownedGear : [ this.item1, this.item1, this.item2, this.item3 ],
//        equipped : [ this.item2, this.item3, this.item1 ]
//    }
    
    constructor( private characterService: CharacterService ) { }
    
    ngOnInit () {
//        
//        setTimeout( () => {
//            this.characterService._character.next(this.char2)
//            console.log(this.race)
//        }, 2000)
        
        this.setColors()
    }
    
    setColors () {
        document.documentElement.style
            .setProperty('--race-color', `var(--${this.race}-color)`)
                
        document.documentElement.style
            .setProperty('--race-color-t', `var(--${this.race}-color-t)`)
                
        document.documentElement.style
            .setProperty('--race-color-d', `var(--${this.race}-color-d)`)
    }
}
