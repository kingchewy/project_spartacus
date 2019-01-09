import { Component, Inject } from '@angular/core'
import { Router } from '@angular/router'
import { PickCharacterComponent } from '../pick-character/pick-character.component'
import { ActivatedRoute } from '@angular/router'
import { Character } from '../character'
import { AttributeRange } from '../mock-attribute-range'

@Component({
  selector: 'pick-char-details',
  templateUrl: './pick-char-details.component.html',
  styleUrls: ['./pick-char-details.component.css']
})
export class PickCharDetailsComponent {
    private race = this.route.snapshot.paramMap.get('race')
    private charName = "Your Fighter"
    private attrRange = AttributeRange[this.race]
    private char: Character = {
        id: 0,
        playerID: 0,
        name: "",
        race: "",
        lvl: 0,
        hp: this.attrRange.minHp,
        armor: this.attrRange.minArmor,
        strength: this.attrRange.minStrength,
        accuracy: this.attrRange.minAccuracy,
        criticalhitchance: this.attrRange.minHitRate,
        agility: this.attrRange.minAgility,
        ownedGear: [],
        equipped: []
    }
    
  constructor(@Inject(PickCharacterComponent) private parent: PickCharacterComponent,
               private route: ActivatedRoute,
              private router: Router) { }
        
    returnToOverview () {
        this.parent.showDetails = false
        this.parent.clickedRace = undefined
        this.router.navigateByUrl("/pick-char")
    }

    pinChoice () {
        let confirmed = confirm(`Are you sure that you are a ${this.race.toUpperCase()} called\n\n${this.charName.toUpperCase()}?\n\nYou won't be able to undo this descicion!`)
        if (confirmed){
            this.parent.showDetails = false
            this.parent.clickedRace = undefined
            
            this.char.name = this.charName
            this.char.race = this.race
            console.log(this.char)
            
            this.router.navigateByUrl("/dialog/" + this.race)
        }
    }
    
}
