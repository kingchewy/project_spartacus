import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'gear-list-basic',
  templateUrl: './gear-list-basic.component.html',
  styleUrls: ['./gear-list-basic.component.css']
})
export class GearListBasicComponent implements OnInit {

    @Input() setting: string
    
  constructor() { }

  ngOnInit() {
  }

}
