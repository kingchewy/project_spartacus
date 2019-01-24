import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Character } from '../model/character';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

    public _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(null);
    public readonly character$: Observable<Character> = this._character.asObservable();
    item1: Item = {
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
    item3: Item = {
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
    item2: Item = {
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
    char: Character = {
        id : 1,
        name : "Green Queen",
        race : "human",
        playerID : 1,
        lvl : 4,
        hp : 1200,
        strength : 5,
        armor : 4,
        accuracy : 7,
        agility : 3,
        criticalhitchance : 0.3,
        ownedGear : [ this.item1, this.item2, this.item3 ],
        equipped : [ this.item2, this.item3 ]
    }
    
    constructor() {
        this._character.next(this.char)
    }    
  getCharacter() {
      return this.character$
  }
}
