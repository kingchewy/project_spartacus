OpeningAnimation = {
    opener: function () {
        document.getElementById("char-picker").style.display = "block"
        
//        document.getElementsByTagName("use")[0].addEventListener("animationend", function () {
//            document.getElementById("logo").remove()
//            document.getElementById("opening-text").style.display = "block"
//            document.getElementById("opening-text").addEventListener("animationend", function () {
//                document.getElementById("opening").remove()
//            })
//        })
//        setTimeout(function(){
//            document.getElementById("background-fader").addEventListener("animationend", function () {
//                this.remove()
//                document.getElementById("char-picker").style.display = "block"
//            })
//            document.body.style.backgroundPosition = "bottom"
//        }, 1500)
    },
    
    showCharDetails: function (that) {
        var chosen = $(that).children("h1")[0].innerHTML

        $(that).siblings().each(function (key, val) {
            val.style.display = "none"                
        })
        $(that).children(".char-description")[0].style.display = "block"
        that.classList.add("char-focus")
        $(".char-choice").removeAttr("onclick")
    },
    pinChoice: function (that){
        var char = $(that).parents('.char-choice')[0],
        chosen = $(char).children('h1')[0].innerHTML

        var confirmed = confirm("Are you sure " + chosen + " is your character of choice? You won't be able to undo this descicion!")
        if (confirmed == true){
            GlobVars.Character.race = char.getAttribute('race')
            document.getElementById("char-picker").style.opacity = "0"
            OpeningAnimation.setDialogCss()
            
            setTimeout(function () {
                document.getElementById("char-picker").remove()
                document.getElementById("create_new_char").style.display = "block"
                Dialog.fillDialog("create_new_char", char.getAttribute("race"))
            },1000)
        }
    },
    returnToOverview: function (){
        var childrenOfPicker = $("#char-picker").children()
        childrenOfPicker.each(function (key, val){
            if ($(val).children(".char-description")[0] != undefined){
                $(val).children(".char-description")[0].style.display = "none"
                val.classList.remove("char-focus")
                val.style.display = "inline-grid"
//??????????????val.onclick = function() { OpeningAnimation.showCharDetails(this) }
            } else {
                val.style.display = "block"
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