import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
    location = "dashboard"
                                   
    constructor( private router: Router ) {
          router.events.subscribe(event => {
              let url = router.url
              this.location = url.substr(url.indexOf("/", 2) + 1)
          })
    }
}
