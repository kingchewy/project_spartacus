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
        discs : 0,
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
        equippedGear: {
            weaponPrimary: null,
            weaponSecondary: null,
            armor: null,
            special: null,
        },
    }
    
    changesToSave: boolean = false
    ignoreFirstChangesCount = 2

    _character: BehaviorSubject<Character> = new BehaviorSubject<Character>(this.char)
    readonly character$: Observable<Character> = this._character.asObservable()

    constructor() {
        this.character$.subscribe( char => {
            this.char = char

            if (this.ignoreFirstChangesCount <= 0) {
                this.changesToSave = true
            } else {
                --this.ignoreFirstChangesCount
            }
        })
    }
    
    removeFromInventory ( item: Item ) {
        this.char.ownedItems = this.char.ownedItems.filter( arrItem => (arrItem !== item) )
        
        this._character.next(this.char)
        
        this.unequip(item.itemType)
    }
    
    unequip ( which:String ) {
        switch ( which.toLowerCase() ){
            case "weaponprimary":
                this.char.equippedGear.weaponPrimary = null
                break
            case "weaponsecondary":
                this.char.equippedGear.weaponSecondary = null
                break
            case "armor":
                this.char.equippedGear.armor = null
                break
            case "special":
                this.char.equippedGear.special = null
                break
            case "weapon":
                this.char.equippedGear.weaponPrimary = null
                this.char.equippedGear.weaponSecondary = null
        }
        this._character.next(this.char)
    }
}
