import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Item } from '../model/item';
import { Shop } from '../model/shop';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

//    private item1s: Item = {
//        id : 1,
//        name : "Stick",
//        itemType : "weapon",
//        characterId : 3,
//        price : 12,
//        minimumLvl : 4,
//        damage : 20,
//        accuracy : 0.6,
//        critDamage : 3,
//        armor : 0,
//        agility : 0
//    }
//    private item2s: Item = {
//        id : 3,
//        name : "Whip",
//        itemType : "weapon",
//        characterId : 3,
//        price : 388,
//        minimumLvl : 4,
//        damage : 600,
//        accuracy : 0.6,
//        critDamage : 3,
//        armor : 0,
//        agility : 0
//    }
//    private item3s: Item = {
//        id : 2,
//        name : "Blaster Master",
//        itemType : "weapon",
//        characterId : 3,
//        price : 10400,
//        minimumLvl : 6,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item4s: Item = {
//        id : 42,
//        name : "axe",
//        itemType : "weapon",
//        characterId : 3,
//        price : 304,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item5s: Item = {
//        id : 22,
//        name : "FlipFlops",
//        itemType : "armor",
//        characterId : 3,
//        price : 424,
//        minimumLvl : 3,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item6s: Item = {
//        id : 11,
//        name : "Latexsiut",
//        itemType : "armor",
//        characterId : 3,
//        price : 666,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item7s: Item = {
//        id : 10,
//        name : "PowerArmor",
//        itemType : "armor",
//        characterId : 3,
//        price : 666,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item8s: Item = {
//        id : 130,
//        name : "Garment",
//        itemType : "armor",
//        characterId : 3,
//        price : 300,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item9s: Item = {
//        id : 150,
//        name : "Chainmail",
//        itemType : "armor",
//        characterId : 3,
//        price : 900,
//        minimumLvl : 0,
//        damage : 0,
//        accuracy : 0,
//        critDamage : 0,
//        armor : 1,
//        agility : 4
//    }
//    private item10s: Item = {
//        id : 120,
//        name : "RobotArm",
//        itemType : "weapon",
//        characterId : 3,
//        price : 1500,
//        minimumLvl : 9,
//        damage : 1200,
//        accuracy : 10,
//        critDamage : 0,
//        armor : 0,
//        agility : 1
//    }
    private shop: Shop = {
        money: 100000,
//        shopitems: [ this.item1s, this.item2s, this.item3s, this.item4s, this.item5s, this.item6s, this.item7s, this.item8s, this.item9s, this.item10s ]
        shopitems: []
    }
        
    public _shop: BehaviorSubject<Shop> = new BehaviorSubject<Shop>(this.shop)
    public readonly shop$: Observable<Shop> = this._shop.asObservable()

    constructor() { }
}
