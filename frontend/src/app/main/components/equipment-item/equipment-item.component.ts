import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'equipment-item',
  templateUrl: './equipment-item.component.html',
  styleUrls: ['./equipment-item.component.css']
})
export class EquipmentItemComponent implements OnInit {

    @Input() setting: string
    private type = "armor"
  constructor() { }

  ngOnInit() {
  }

}
