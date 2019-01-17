import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'dash-board',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
    private userName = "Green Queen"
    
  constructor() { }

  ngOnInit() {
      document.body.style.backgroundPosition = "bottom"
      document.body.style.backgroundImage="url(Akira-bg-1.jpg)"
  }

}
