import { Component, OnInit } from '@angular/core'
import { NightFightService, User } from '../../night-fight.service'
import { LoginService } from '../login.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit{
    newUser = new User()
    private password = ""
    private passwordConf = ""
    
    constructor ( private nightFightService: NightFightService, 
                   private loginService: LoginService) {}

    ngOnInit () {
        this.newUser.name = ""
        this.newUser.eMail = ""
        this.newUser.password = ""
        this.newUser.blocked = 0
        this.newUser.date = "2018-09-11"
        console.log(this.loginService.login("Fiese Liese", "asdf"))
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
        this.nightFightService.retrieveAllAccounts()
    }
}
