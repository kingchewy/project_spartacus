import { Component } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Lvl } from '../../shared/lvl-xp-borders'

@Component({
  selector: 'xp-bar',
  templateUrl: './xp-bar.component.html',
  styleUrls: ['./xp-bar.component.css']
})
export class XpBarComponent {

    currentXp = this.characterService._character.value.xp
    charName = this.characterService._character.value.name

    currLvl = this.characterService._character.value.lvl
    nextLvl = this.currLvl + 1
    thisLvlXp = Lvl[this.characterService._character.value.lvl].fromXp
    nextLvlXp = Lvl[this.characterService._character.value.lvl].toXp
    
  constructor( private characterService: CharacterService ) {}
}
