import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs'
import { Character } from '../model/character';
import { Item } from '../model/item';
import { Shop } from '../model/shop';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor() { }
    
    getPlayerCharacter(): Observable<Character> {
        let item1: Item = {
            id : 1,
            name : "Lanze",
            type : "weapon",
            characterId : 3,
            price : 123,
            minimumLvl : 4,
            damage : 120,
            accuracy : 0.6,
            critDamage : 3,
            armor : 0,
            agility : 0
        }
        let item3: Item = {
            id : 3,
            name : "Harpune",
            type : "weapon",
            characterId : 3,
            price : 321,
            minimumLvl : 4,
            damage : 1000,
            accuracy : 0.6,
            critDamage : 3,
            armor : 0,
            agility : 0
        }
        let item2: Item = {
            id : 2,
            name : "flipflops",
            type : "armor",
            characterId : 3,
            price : 666,
            minimumLvl : 0,
            damage : 0,
            accuracy : 0,
            critDamage : 0,
            armor : 1,
            agility : 4
        }
        let char: Character = {
            id : 1,
            name : "Green Queen",
            race : "robot",
            playerID : 1,
            money : 1500,
            lvl : 4,
            hp : 1200,
            xp : 1900,
            attack: 100,
            strength : 3,
            armor : 1,
            accuracy : 7,
            agility : 6,
            criticalhitchance : 0.5,
            ownedGear : [ item1, item2, item3 ],
            equipped : [ item2 ]
        }
        return of (char)
    }
}
