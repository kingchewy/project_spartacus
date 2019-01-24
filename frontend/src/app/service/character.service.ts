import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Character } from '../model/character';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})

export class CharacterService {

    private item1: Item = {
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
    private item3: Item = {
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
    private item2: Item = {
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
    private char: Character = {
        id : 1,
        name : "Green Queen",
        race : "human",
        playerID : 1,
        money : 1500,
        lvl : 4,
        hp : 1200,
        attack: 100,
        strength : 3,
        armor : 1,
        accuracy : 7,
        agility : 6,
        criticalhitchance : 0.5,
        ownedGear : [ this.item1, this.item2, this.item3 ],
        equipped : [ this.item2 ]
    }
    
    public _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(this.char)
    public readonly character$: Observable<Character> = this._character.asObservable()

    constructor() {
        this.char.equipped.forEach( item => this.setCharStats(item) )
    }
    
    removeFromInventory ( item: Item ) {
        this.char.ownedGear = this.char.ownedGear.filter( arrItem => (arrItem !== item) )
        this.unequipp( item )
        this._character.next(this.char)
    }
    
    unequipp ( item: Item ) {
        this.char.equipped = this.char.equipped.filter( arrItem => (arrItem !== item) )
        this._character.next(this.char)

        this.resetCharStats(item)
    }
    
    setCharStats ( item: Item ) {
        this.char.attack += item.damage
        this.char.accuracy += item.accuracy
        this.char.criticalhitchance += item.critDamage
        this.char.armor += item.armor
        this.char.agility += item.agility
    }
    
    resetCharStats ( item: Item ) {
            this.char.attack -= item.damage
            this.char.accuracy -= item.accuracy
            this.char.criticalhitchance -= item.critDamage
            this.char.armor -= item.armor
            this.char.agility -= item.agility
    }
}
