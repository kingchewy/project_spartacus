import { Component } from '@angular/core';
import { Item } from '../../../model/item';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent {

    constructor() {
        document.body.setAttribute("class","background-shop")
    }
    
}
