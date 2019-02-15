import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs'
import { Character } from '../model/character';
import { Item } from '../model/item';
import { Shop } from '../model/shop';

const RESCOURCES = 'http://localhost:8080/night_fight/resources'

@Injectable({
  providedIn: 'root'
})

export class RequestCharService {

  constructor(private httpClient: HttpClient) { }
    
//    getPlayerCharacter(): Observable<Character> {
//        return this.httpClient.get<Character>(RESCOURCES + '/characters/1');
//    }
    
    getPlayerCharacter(): Observable<Character> {
//        let item1: Item = {
//            id : 1,
//            name : "Lanze",
//            itemType : "weapon",
//            characterId : 3,
//            price : 123,
//            minimumLvl : 4,
//            damage : 120,
//            accuracy : 0.6,
//            critDamage : 3
//        }
//        let item4: Item = {
//            id : 1,
//            name : "Zweihänder",
//            itemType : "weapon",
//            characterId : 3,
//            price : 123,
//            minimumLvl : 4,
//            damage : 120,
//            accuracy : 0.6,
//            critDamage : 3,
//            armor : 0,
//            agility : 0,
//            twohanded : true
//        }
//        let item3: Item = {
//            id : 3,
//            name : "Harpune",
//            itemType : "weapon",
//            characterId : 3,
//            price : 321,
//            minimumLvl : 4,
//            damage : 1000,
//            accuracy : 0.6,
//            critDamage : 3,
//            armor : 0,
//            agility : 0
//        }
//        let item2: Item = {
//            id : 2,
//            name : "flipflops",
//            itemType : "armor",
//            characterId : 3,
//            price : 666,
//            minimumLvl : 0,
//            damage : 0,
//            accuracy : 0,
//            critDamage : 0,
//            armor : 1,
//            agility : 4
//        }
//        let item5: Item = {
//            id : 25,
//            name : "scales",
//            itemType : "armor",
//            characterId : 3,
//            price : 666,
//            armor : 12,
//            agility : 4
//        }
//        let item6: Item = {
//            id : 26,
//            name : "skin",
//            itemType : "armor",
//            characterId : 3,
//            price : 666,
//            armor : 10,
//            agility : 4
//        }
//        let item7: Item = {
//            id : 27,
//            name : "Bad Mood",
//            itemType : "weapon",
//            characterId : 3,
//            price : 666,
//            minimumLvl : 3,
//            damage : 200,
//            accuracy : 100,
//            critDamage : 100,
//            agility : 4
//        }
        let char: Character = {
            id : 1,
            name : "Green Queen",
            race : "monster",
            playerID : 1,
            discs : 1500,
            lvl : 4,
            hp : 1200,
            xp : 1900,
            attack: 100,
            strength : 3,
            armor : 1,
            accuracy : 7,
            agility : 6,
            criticalhitchance : 0.5,
//            ownedItems : [ item1, item2, item3, item4, item5, item6, item7 ],
            ownedItems : [],
            equippedGear: {
                characterId: 1,
                weaponPrimary: null,
                weaponSecondary: null,
                armor: null,
                special: null,
            },
        }
        return of (char)
    }
}
