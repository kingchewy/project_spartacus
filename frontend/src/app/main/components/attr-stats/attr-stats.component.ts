import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'attr-stats',
  templateUrl: './attr-stats.component.html',
  styleUrls: ['./attr-stats.component.css']
})
export class AttrStatsComponent {
    private observer = this.characterService.character$.subscribe( char => {
        this.char = char
        
        this.attack = 0
        this.armor = char.armor
        this.strength = char.strength
        this.accuracy = char.accuracy
        this.criticalDamage = char.criticalhitchance
        this.agility = char.agility
        this.calcStats();
        })
    private char: Character
        
    private attack: number
    private armor: number
    private strength: number
    private accuracy: number
    private criticalDamage: number
    private agility: number
    
    constructor( private characterService: CharacterService ) {}
    
    calcStats () {
        this.calcSlots("weaponPrimary")
        this.calcSlots("weaponSecondary")
        this.calcSlots("armor")
        this.calcSlots("special")
    }
    
    calcSlots ( slot ) {
        let items = this.char.equippedGear
        if ( items[slot] ) {
            this.attack += items[slot].damage || 0
            this.armor += items[slot].armor || 0
            this.accuracy += items[slot].accuracy || 0
            this.criticalDamage += items[slot].critDamage || 0
            this.agility += items[slot].agility || 0
        }      
    }
}
