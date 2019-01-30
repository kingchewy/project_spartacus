import { Component, OnInit, Input } from '@angular/core';
import { CharacterService } from '../../../service/character.service';
import { ShopService } from '../../../service/shop.service';
import { Character } from '../../../model/character';
import { Item } from '../../../model/item';
import { Shop } from '../../../model/shop';

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
    
    private observeChar = this.characterService.character$.subscribe( x => this.char = x )
    private char: Character
    
    private observeShop = this.shopService.shop$.subscribe( x => this.shop = x )
    private shop: Shop
    
  constructor( private characterService: CharacterService,
               private shopService: ShopService ) { }
 
    take ( item: Item ) {
        let notYetSelected = this.itemList.every( selected => item != selected )
        let passes: boolean
            if ( this.setting == "yours" ) {
                passes = ( this.price + item.price <= this.shop.money ) && notYetSelected
            } else if ( this.setting == "shop" ){
                passes = (this.price + item.price <= this.char.money) && notYetSelected 
            }
        
        if ( passes ) {
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
        this.shop.money -= this.price
        
        this.itemList.forEach( item => this.characterService.removeFromInventory(item) )
        this.characterService._character.next(this.char)
        
        this.itemList.forEach ( item => this.shop.items.push(item) )
        this.shopService._shop.next(this.shop)
        
        this.itemList = []
        this.price = 0
    }
    
    buySelected () {
        this.char.money -= this.price
        this.shop.money += this.price
        
        this.itemList.forEach ( item => this.char.ownedGear.push(item) )
        this.characterService._character.next(this.char)
        
        this.shop.items = this.shop.items.filter ( item => {
            return this.itemList.every ( selected => selected != item )
        })
        this.shopService._shop.next(this.shop)
        
        this.itemList = []
        this.price = 0
    }
}
