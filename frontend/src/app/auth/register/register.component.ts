import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NightFightService, User } from '../../night-fight.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit{
    newUser = new User()
    private password = ""
    private passwordConf = ""
    
    constructor (
        private authService: AuthService,
        private router: Router
        ) {}

    ngOnInit () {
        this.newUser.name = ""
        this.newUser.eMail = ""
        this.newUser.password = ""
        //console.log(this.authService.login("Fiese Liese", "asdf"))
//        this.nightFightService.retrieveAllAccounts()
    }
    
    checkInput () {
        if (( this.newUser.name != "" && this.newUser.eMail != "" && this.password != "" && this.passwordConf != "" )
            && ( this.password == this.passwordConf )){
            return true
        }
        return false
    }
    
    submit () {
        this.newUser.password = this.password
        console.log(this.newUser)
        //this.nightFightService.createAccount(this.newUser)
        //this.nightFightService.retrieveAllAccounts()
        this.router.navigateByUrl("/intro/newUser")
    }
}
