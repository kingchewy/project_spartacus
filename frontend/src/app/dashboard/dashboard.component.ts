import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'dash-board',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
    private charName = "Green Queen"
    
  constructor() { }

  ngOnInit() {
  }

}
