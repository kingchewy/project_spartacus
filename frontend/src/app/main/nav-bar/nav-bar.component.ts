import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CharacterService } from '../../service/character.service';
import { Character } from '../../model/character';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
    location = "dashboard"
    private char = this.characterService.character$.subscribe( x => {
        this.name = x.name
    })
    private name: string
    
    constructor( private router: Router,
                  private characterService: CharacterService ) {
          router.events.subscribe(event => {
              let url = router.url
              this.location = url.substr(url.indexOf("/", 2) + 1)
          })
    }
}
