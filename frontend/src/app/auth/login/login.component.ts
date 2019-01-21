import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { NightFightService, User } from '../../night-fight.service'
import { LoginService } from '../login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user = new User()
    private password = ""
    
    constructor ( private nightFightService: NightFightService, 
                    private loginService: LoginService,
                    private router: Router) {}

    ngOnInit () {
        this.user.eMail = ""
        this.user.password = ""
//        console.log(this.loginService.login("Fiese Liese", "asdf"))
//        this.nightFightService.retrieveAllAccounts()
    }
    
    checkInput () {
        if (( this.user.eMail != "" && this.password != "" )){
            return true
        }
        return false
    }
    
    submit () {
        this.user.password = this.password
        console.log(this.user)
        //this.nightFightService.createAccount(this.newUser)
        //this.nightFightService.retrieveAllAccounts()
        this.router.navigateByUrl("/intro")
    }
}
