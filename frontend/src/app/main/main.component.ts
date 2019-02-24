import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../service/character.service';
import { UserService } from '../service/user.service';
import { RequestCharService } from '../service/request-char.service';
import { RequestUserService } from '../service/request-user.service'
import { Character } from '../model/character';
import { Item } from '../model/item';
import { User } from '../model/user';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
    
    private user: User
    
    constructor( private characterService: CharacterService ,
                  private userService: UserService ,
                  private requestCharService: RequestCharService,
                  private requestUserService: RequestUserService  ) { }
    
    ngOnInit () {
        this.requestUserService.getThisUser().
            subscribe( user => {
            this.userService._user.next( user )
            this.characterService._character.next ( user.characters[0] )
            this.setColors( user.characters[0].race )
            
            console.log(user.characters[0])
        })
    }

    setColors (race) {
        document.documentElement.style
            .setProperty('--race-color', `var(--${race}-color)`)
                
        document.documentElement.style
            .setProperty('--race-color-t', `var(--${race}-color-t)`)
                
        document.documentElement.style
            .setProperty('--race-color-d', `var(--${race}-color-d)`)
    }
}
