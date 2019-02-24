import { Component, OnDestroy } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { RequestCharService } from '../../../service/request-char.service';
import { Character } from '../../../model/character';

@Component({
  selector: 'app-char-details',
  templateUrl: './char-details.component.html',
  styleUrls: ['./char-details.component.css']
})
export class CharDetailsComponent implements OnDestroy {
    private observe = this.characterService.character$.subscribe( char => {
        this.char = char
    })
    private char: Character
    
    constructor( private characterService: CharacterService,
                  private requestCharService: RequestCharService ) {
        document.body.setAttribute("class","background-char-details")
        
        window.addEventListener("beforeunload", event => {
            if (this.characterService.changesToSave) { 
                event.returnValue = "Equipped Items not saved jet"
                this.equipEquipped()
            }
        })
    }
    
    ngOnDestroy () {
        this.equipEquipped()
    }
    
    equipEquipped () {
        if (this.characterService.changesToSave) {
            let equipPackage = this.char.equippedGear
            
            if (!this.char.equippedGear.weaponPrimary) {
                delete equipPackage.weaponPrimary
            }
            if (!this.char.equippedGear.weaponSecondary) {
                delete equipPackage.weaponSecondary
            }
            if (!this.char.equippedGear.armor) {
                delete equipPackage.armor
            }
            if (!this.char.equippedGear.special) {
                delete equipPackage.special
            }
            this.requestCharService.equip(equipPackage).then( message => {
                this.characterService.changesToSave = false
                console.log(message)
            })
        }
    }
}
