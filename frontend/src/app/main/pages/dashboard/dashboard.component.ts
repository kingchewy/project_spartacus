import { Component } from '@angular/core';
import { RequestUserService } from '../../../service/request-user.service'
@Component({
  selector: 'dash-board',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
    private userName: string
    
    constructor( private requestUserService: RequestUserService ) { 
        document.body.setAttribute("class","background-base")

        this.requestUserService.getThisUser().
                subscribe( user => this.userName = user.name )
    }

}
