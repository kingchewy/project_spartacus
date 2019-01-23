import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';

@Component({
  selector: 'attr-stats',
  templateUrl: './attr-stats.component.html',
  styleUrls: ['./attr-stats.component.css']
})
export class AttrStatsComponent implements OnInit {
    private char = this.characterService.getCharacter().subscribe( x => {
        this.hp = x.hp
        this.armor = x.armor
        this.critHitChance = x.criticalhitchance
        this.strength = x.strength
        this.accuracy = x.accuracy
        this.agility = x.agility
    })
    private hp: number
    private armor: number
    private critHitChance: number
    private strength: number
    private accuracy: number
    private agility: number
    
  constructor( private characterService: CharacterService ) { }

  ngOnInit() {
  }

}
