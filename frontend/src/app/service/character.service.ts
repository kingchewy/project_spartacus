import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Character } from '../model/character';
import { Item } from '../model/item';
import { Shop } from '../model/shop';

@Injectable({
  providedIn: 'root'
})

export class CharacterService {

    private char: Character = {
        id : 0,
        name : "loading…",
        race : "",
        playerID : 0,
        money : 0,
        lvl : 0,
        hp : 0,
        xp : 0,
        attack: 0,
        strength : 0,
        armor : 0,
        accuracy : 0,
        agility : 0,
        criticalhitchance : 0,
        ownedGear : [],
        equipped : []
    }

    _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(this.char)
    readonly character$: Observable<Character> = this._character.asObservable()

    constructor() {
        this.character$.subscribe( char => {
            this.char = char
            char.equipped.forEach( item => this.setCharStats(item) )
        })
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
        console.log("set")
        this.char.attack = Math.round(this.char.attack + item.damage)
        this.char.accuracy = Math.round(this.char.accuracy + item.accuracy)
        this.char.criticalhitchance = Math.round(this.char.criticalhitchance + item.critDamage)
        this.char.armor = Math.round(this.char.armor + item.armor)
        this.char.agility = Math.round(this.char.agility + item.agility)
    }
    
    resetCharStats ( item: Item ) {
        console.log("reset")
        this.char.attack = Math.round(this.char.attack - item.damage)
        this.char.accuracy = Math.round(this.char.accuracy - item.accuracy)
        this.char.criticalhitchance = Math.round(this.char.criticalhitchance - item.critDamage)
        this.char.armor = Math.round(this.char.armor - item.armor)
        this.char.agility = Math.round(this.char.agility - item.agility)
    }
}
