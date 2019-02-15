import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CharacterService } from '../../service/character.service';
import { Character } from '../../model/character';
import { UserService } from '../../service/user.service';
import { User } from '../../model/user';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
    location = "dashboard"
    private char = this.characterService.character$.subscribe( char => {
        this.charName = char.name
    })
    private charName = "char"
    private userName = "account"
    
    constructor( private router: Router,
                  private characterService: CharacterService,
                  private userService: UserService ) {
        
        router.events.subscribe(event => {
            //get current url location (string after second "/")
            let url = router.url
            this.location = url.substr(url.indexOf("/", 2) + 1)
        })
        
        this.userService.user$.subscribe( user => this.userName = user.name )
    }
    
    checkChangesAndNavigate( link ) {
//
//        if (this.characterService.changesToSave) {
//            console.log(this.characterService._character.getValue())
//        }
//        
//        this.characterService.changesToSave = false
        this.router.navigateByUrl("base/" + link )
    }
}
