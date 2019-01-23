import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../../../model/item';

@Component({
  selector: 'equipment-item',
  templateUrl: './equipment-item.component.html',
  styleUrls: ['./equipment-item.component.css']
})
export class EquipmentItemComponent implements OnInit {

    @Input() setting: string
    @Input() item: Item

  constructor() { }

  ngOnInit() {}

}
