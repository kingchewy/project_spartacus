OpeningAnimation = {
    opener: function () {
        document.getElementsByTagName("use")[0].addEventListener("animationend", function(){
            document.getElementById("opening").remove()
        })
        setTimeout(function(){
            document.getElementById("background-fader").addEventListener("animationend", function(){
                this.remove()
                document.getElementById("char-picker").style.display = "block"
                document.getElementsByClassName("char-choice")[0].addEventListener("click", function(){
                    document.getElementById("char-picker").remove()
                    document.getElementById("create_new_char").style.display = "block"                    
                })
            })
            document.body.style.backgroundPosition = "bottom"
        }, 1500)
    }
}