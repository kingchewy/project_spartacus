import { Component } from '@angular/core';
import { Item } from '../../../model/item';
import { RequestShopService } from '../../../service/request-shop.service'
import { ShopService } from '../../../service/shop.service'

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent {

    constructor( private requestShopService: RequestShopService,
                 private shopService: ShopService ) {
        document.body.setAttribute("class","background-shop")
        
        this.requestShopService.getShop().subscribe( shop => this.shopService._shop.next( shop ))
    }
    
}
