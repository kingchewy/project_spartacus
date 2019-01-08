import { Component, OnInit } from '@angular/core';
import { NightFightService, Account } from '../night-fight.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit{
    newAccount = new Account()
    private password = ""
    private passwordConf = ""
    
    constructor ( private nightFightService: NightFightService ) {}

    ngOnInit () {
        this.newAccount.name = ""
        this.newAccount.eMail = ""
        this.newAccount.password = ""
        this.newAccount.blocked = 0
        this.newAccount.date = "2018-09-11"
    }
    
    checkInput () {
        if (( this.newAccount.name != "" && this.newAccount.eMail != "" && this.password != "" && this.passwordConf != "" )
            && ( this.password == this.passwordConf )){
            return true
        }
        return false
    }
    
    submit () {
        this.newAccount.password = this.password
        console.log(this.newAccount)
        this.nightFightService.createAccount(this.newAccount)
    }
}
