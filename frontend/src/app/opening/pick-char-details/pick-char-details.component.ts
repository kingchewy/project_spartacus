import { Component, Inject, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PickCharacterComponent } from '../pick-character/pick-character.component';
import { AttributeRange } from './mock-attribute-range';
import { Character } from '../../model/character';

@Component({
  selector: 'pick-char-details',
  templateUrl: './pick-char-details.component.html',
  styleUrls: ['./pick-char-details.component.css']
})
export class PickCharDetailsComponent {
    @Input() race: string
    private charName = "Your Fighter"
    private attrRange: any
    private char: Character
    
  constructor(@Inject(PickCharacterComponent) private parent: PickCharacterComponent,
              private router: Router) {}
        
    ngOnInit () {
        this.attrRange = AttributeRange[this.race]
        this.char = {
            id: 0,
            playerID: 0,
            name: "",
            race: "",
            lvl: 0,
            attack: 100,
            hp: this.attrRange.minHp,
            xp: 0,
            armor: this.attrRange.minArmor,
            strength: this.attrRange.minStrength,
            accuracy: this.attrRange.minAccuracy,
            criticalhitchance: this.attrRange.minHitRate,
            agility: this.attrRange.minAgility,
            ownedGear: [],
            equipped: [],
            money: 0
        }
    }
    
    returnToOverview () {
        this.parent.showDetails = false
        this.parent.clickedRace = undefined
        this.router.navigateByUrl("/opening/pick-char")
    }

    pinChoice () {
        let confirmed = confirm(`Are you sure that you are a ${this.race.toUpperCase()} called\n\n${this.charName.toUpperCase()}?\n\nYou won't be able to undo this descicion!`)
        if (confirmed){
            this.parent.showDetails = false
            this.parent.clickedRace = undefined
            
            this.char.name = this.charName
            this.char.race = this.race
            console.log(this.char)
            
            this.router.navigateByUrl("/base/dialog/" + this.race)
        }
    }
    
}
