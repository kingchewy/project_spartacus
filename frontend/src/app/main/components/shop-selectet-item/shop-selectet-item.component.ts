import { Component, OnInit, Input } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';

@Component({
  selector: 'shop-selectet-item',
  templateUrl: './shop-selectet-item.component.html',
  styleUrls: ['./shop-selectet-item.component.css']
})
export class ShopSelectetItemComponent {
    @Input() private setting: string
    private itemList: Item[] = []
    private price: number = 0
    private warnPrice: boolean = false
    
    private observe = this.characterService.character$.subscribe( x => this.char = x )
    private char: Character
    
  constructor( private characterService: CharacterService ) { }
 
    take ( item: Item ) {
        let notYetSelected = this.itemList.every( selected => item != selected )

        if ( (this.price + item.price <= this.char.money) && notYetSelected ) {
            this.itemList.push(item)
            this.calcPrice()   
        } else if (notYetSelected) {
            this.warnPrice = true
            setTimeout ( () => {
                this.warnPrice = false
            }, 2000)
        }
    }
    
    eject ( clicked: Item ) {
        this.itemList = this.itemList.filter ( item => clicked != item )
        this.calcPrice()
    }
    
    calcPrice () {
        this.price = 0
        this.itemList.forEach( item => this.price += item.price )
    }
    
    sellSelected () {
        this.char.money += this.price
        
        this.itemList.forEach( item => this.characterService.removeFromInventory(item) )

        this.characterService._character.next(this.char)
        this.itemList = []
    }
    
    buySelected () {
        this.char.money -= this.price
    }
}
