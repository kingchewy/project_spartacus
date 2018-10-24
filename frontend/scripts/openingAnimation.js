OpeningAnimation = {
    opener: function () {
        //OpeningAnimation.chooseChar()
        
        document.getElementsByTagName("use")[0].addEventListener("animationend", function () {
            document.getElementById("logo").remove()
            document.getElementById("opening-text").style.display = "block"
            document.getElementById("opening-text").addEventListener("animationend", function () {
                document.getElementById("opening").remove()
            })
        })
        setTimeout(function(){
            document.getElementById("background-fader").addEventListener("animationend", function () {
                this.remove()
                OpeningAnimation.chooseChar()
            })
            document.body.style.backgroundPosition = "bottom"
        }, 1500)
    },
    
    chooseChar: function () {
        var charPick = document.getElementById("char-picker").style
        charPick.willChange = "margin-top"
        charPick.display = "block"
        charPick.willChange = "auto"
        
        $(".char-choice").click(function () {
            var that = this,
            chosen = $(this).children("h1")[0].innerHTML,
            confirmed = confirm("Are you sure " + chosen + " is your character of choice? You won't be able to undo this descicion!")
            
            if (confirmed == true){
                GlobVars.Character.race = that.getAttribute("race")
                document.getElementById("char-picker").style.opacity= "0"
                OpeningAnimation.setDialogCss()
                
                setTimeout(function () {
                    document.getElementById("char-picker").remove()
                    document.getElementById("create_new_char").style.display = "block"
                    Dialog.fillDialog("create_new_char", that.getAttribute("id"))
                },1000)
            }            
        })
    },
    setDialogCss: function (){
        var sheet = document.styleSheets[0]['cssRules']
        for (ix = 0; ix < sheet.length; ix++){
            if(sheet[ix].selectorText == ".you-bubble"){
                sheet[ix].style.borderColor = "rgb(" + GlobVars.RaceColors[GlobVars.Character.race].primary + ")"
                sheet[ix].style.backgroundColor = "rgba(" + GlobVars.RaceColors[GlobVars.Character.race].secondary + ",0.7)"
                sheet[ix].style.color = "rgb(" + GlobVars.RaceColors[GlobVars.Character.race].primary + ")"
            }
        }
    }
}