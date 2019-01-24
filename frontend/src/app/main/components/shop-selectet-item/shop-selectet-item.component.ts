import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'shop-selectet-item',
  templateUrl: './shop-selectet-item.component.html',
  styleUrls: ['./shop-selectet-item.component.css']
})
export class ShopSelectetItemComponent implements OnInit {
    @Input() private setting: string
    
  constructor() { }

  ngOnInit() {
  }

}
