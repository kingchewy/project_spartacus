import { Component } from '@angular/core';

@Component({
  selector: 'search-overview',
  templateUrl: './search-overview.component.html',
  styleUrls: ['./search-overview.component.css']
})
export class SearchOverviewComponent {

    private visible = "No"
    
    constructor() { }
    
    setVisibility () {
        if (this.visible.toLowerCase() == "yes") {
            this.visible = "No"
        } else if (this.visible.toLowerCase() == "no") {
            this.visible = "Yes"
        }
    }
}
