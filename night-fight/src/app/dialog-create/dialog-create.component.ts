import { Component, OnInit } from '@angular/core'
import { PickCharacterComponent } from '../pick-character/pick-character.component'
import { Character } from '../character'

@Component({
  selector: 'dialog-create',
  templateUrl: './dialog-create.component.html',
  styleUrls: ['./dialog-create.component.css']
})
export class DialogCreateComponent implements OnInit {
    
  constructor() { }

  ngOnInit() { 
      //this.fillDialog('human')
  }
    
    
//    fillDialog (character): void{
//        var container = document.getElementById('dialog-create')
//        container.style.willChange = "contents"
//        character = character.split(" ").join("").toLowerCase()
//        var html= BuildThis.dialog(GlobVars.Dialog[character])
//        
//        container.innerHTML = html
//        container.style.willChange = "auto"
//        Dialog.tellStory(container)
//    }
    
    
    
    //speakerAndQuote => {
    //    var html = ""
    //    speakerAndQuote.forEach((val, key) => {
    //        if (val[0] == "N"){
    //            html += `<div class='narrator-bubble hide-dialog'><div>${val[1]}</div></div>\n`
    //        } else if (val[0] == "Y"){
    //            html += `<div class='you-bubble hide-dialog'><div>${val[1]}</div></div>\n`                
    //        }
    //    })
    //    html += "<button id='dialog-story-btn'>Onward</button>"
    //    return html
    //}
}
