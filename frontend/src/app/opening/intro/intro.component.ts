import { Component, OnInit } from '@angular/core'
import { Router, ActivatedRoute } from '@angular/router'

@Component({
  selector: 'intro',
  templateUrl: './intro.component.html',
  styleUrls: ['./intro.component.css']
})

export class IntroComponent implements OnInit {  
      private newUser = this.route.snapshot.paramMap.get('newUser')

    constructor( private route: ActivatedRoute,
                  private router: Router ) { }

  ngOnInit() {
      document.body.style.backgroundPosition = "bottom"

      document.getElementsByTagName("use")[0].addEventListener("animationend", () => {
          document.getElementById("logo").remove()
  //        document.getElementById("opening-text").style.display = "block"
////          document.getElementById("opening-text").addEventListener("animationend", () => {
////              document.getElementById("opening").remove()
//          })
          document.getElementById("background-fader").addEventListener("animationend", dn => {
              if ( this.newUser ) {
                this.router.navigateByUrl("opening/pick-char")
              } else {
                this.router.navigateByUrl("/base/dashboard")                  
              }
          })
      })

}}