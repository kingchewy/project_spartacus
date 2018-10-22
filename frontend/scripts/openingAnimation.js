OpeningAnimation = {
    opener: function () {
        document.getElementsByTagName("use")[0].addEventListener("animationend", function(){
            document.getElementById("opening").remove()
        })
        setTimeout(function(){
            document.getElementById("background-fader").addEventListener("animationend", function(){
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
        
        $(".char-choice").click(function(){
            var chosen = $(this).children("h1")[0].innerHTML
            var confirmed = confirm("Are you sure " + chosen + " is your character of choice? You won't be able to undo this descicion!")
            if (confirmed == true){
                document.getElementById("char-picker").remove()
                document.getElementById("create_new_char").style.display = "block"
                Dialog.fillDialog("create_new_char", chosen)   
            }            
        })
    }
}