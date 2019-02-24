import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Lvl } from '../../shared/lvl-xp-borders'

@Component({
  selector: 'xp-bar',
  templateUrl: './xp-bar.component.html',
  styleUrls: ['./xp-bar.component.css']
})
export class XpBarComponent {

    private currentXp : number
    private charName : string

    private currLvl : number
    private nextLvl : number
    private thisLvlXp : number
    private nextLvlXp : number
    
    
  constructor( private characterService: CharacterService ) {
      this.characterService.character$.subscribe( char => {
        this.currentXp = this.characterService._character.value.xp
        this.charName = this.characterService._character.value.name
    
        this.currLvl = this.characterService._character.value.lvl
        this.nextLvl = this.currLvl + 1
        this.thisLvlXp = Lvl[this.characterService._character.value.lvl].fromXp
        this.nextLvlXp = Lvl[this.characterService._character.value.lvl].toXp
      })
  }
}
