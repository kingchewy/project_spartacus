import { Component } from '@angular/core'
import { PickCharacterComponent } from '../pick-character/pick-character.component'
import { Character } from '../character'
import { ActivatedRoute } from '@angular/router'
import { Dialog } from '../mock-dialog'

@Component({
  selector: 'story-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {
    private dialog = Dialog
    private race = this.route.snapshot.paramMap.get('race')
    private showBubbleUntil = 1
    private bubbleIds = 1
    
    constructor( private route: ActivatedRoute ) {}

    ngOnInit() { }
    
    showBubbles () : number {
        this.bubbleIds++
        return this.bubbleIds
    }
    
    showNextBubble () {
        this.showBubbleUntil++
    }
    
    tellStory () {
        let FirstHideDialog = document.getElementsByClassName("hide-dialog")[0]
        
        if (FirstHideDialog){
            FirstHideDialog.classList.add("show-dialog")
            FirstHideDialog.classList.remove("hide-dialog")
//            console.log(FirstHideDialog.offsetTop + FirstHideDialog.offsetHeight + 50, window.innerHeight)
            //if (FirstHideDialog.offsetTop + FirstHideDialog.offsetHeight + 50 > window.innerHeight){
            //    window.scrollTo({top: scrollY + FirstHideDialog.offsetHeight + 50, behavior: "smooth"})   
            //}
        } else {
            confirm(`Have you finished reading the story\nfand do you want to continue?`)
        }
    }
}
