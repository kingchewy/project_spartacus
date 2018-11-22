import { Component, OnInit } from '@angular/core'

@Component({
  selector: 'intro',
  templateUrl: './intro.component.html',
  styleUrls: ['./intro.component.css']
})

export class IntroComponent implements OnInit {  
  constructor() { }

  ngOnInit() {
      document.body.style.backgroundPosition = "bottom"
      document.getElementsByTagName("use")[0].addEventListener("animationend", () => {
          document.getElementById("logo").remove()
          document.getElementById("opening-text").style.display = "block"
          document.getElementById("opening-text").addEventListener("animationend", () => {
              document.getElementById("opening").remove()
          })
          document.getElementById("background-fader").addEventListener("animationend", dn => {
              document.getElementById("char-picker").style.display = "block"
          })
      })

}}