import { Component, Input, EventEmitter, Output, OnInit } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { ShopService } from '../../../service/shop.service';
import { Character } from '../../../model/character';
import { Shop } from '../../../model/shop';
import { Item } from '../../../model/item';

@Component({
  selector: 'gear-list-basic',
  templateUrl: './gear-list-basic.component.html',
  styleUrls: ['./gear-list-basic.component.css']
})
export class GearListBasicComponent implements OnInit{

    @Input() setting: string    
    @Output() private add = new EventEmitter<Item>()
    
    private observe
    
    private char: Character
    private shop: Shop
    
    constructor( private characterService: CharacterService,
                 private shopService: ShopService ) {}
    
    ngOnInit () {
        if (this.setting == "yours") {
            this.observe = this.characterService.character$.subscribe( x => {
                this.char = x
            })            
        } else if (this.setting == "shop") {
            this.observe = this.shopService.shop$.subscribe( x => {
                this.shop = x
            })
        }

    }
}
