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
        ownedItems : [],
        equippedItems: {
            characterId: 1,
            weaponPrimary: null,
            weaponSecondary: null,
            armor: null,
            special: null,
        },
    }

    _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(this.char)
    readonly character$: Observable<Character> = this._character.asObservable()

    constructor() {
        this.character$.subscribe( char => this.char = char )
    }
    
    removeFromInventory ( item: Item ) {
        this.char.ownedItems = this.char.ownedItems.filter( arrItem => (arrItem !== item) )
        
        this._character.next(this.char)
        
        this.unequip(item.type)
    }
    
    unequip ( which:String ) {
        switch ( which.toLowerCase() ){
            case "weaponprimary":
                this.char.equippedItems.weaponPrimary = null
                break
            case "weaponsecondary":
                this.char.equippedItems.weaponSecondary = null
                break
            case "armor":
                this.char.equippedItems.armor = null
                break
            case "special":
                this.char.equippedItems.special = null
                break
            case "weapon":
                this.char.equippedItems.weaponPrimary = null
                this.char.equippedItems.weaponSecondary = null
        }
        this._character.next(this.char)
    }
}
