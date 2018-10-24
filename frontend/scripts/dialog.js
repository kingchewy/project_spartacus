Dialog = {
    fillDialog: function (dialogContainer, character) {
        var container = document.getElementById(dialogContainer)
        container.style.willChange = "contents"
        character = character.split(" ").join("").toLowerCase()
        var html= BuildThis.dialog(GlobVars.Dialog[character])
        
        container.innerHTML = html
        container.style.willChange = "auto"
        //Dialog.enableDialogScroll()
        Dialog.tellStory(container)
    },
           
    enableDialogScroll: function () {
           
        window.addEventListener("scroll", function (){
           
            $(".dialog > div").each(function (key, val){
                var height = val.clientHeight,
                    posTop = val.getBoundingClientRect().top
                
                val.style.marginTop = "0px"
                val.style.marginBottom = "50px"

//Damit es "funktioniert" muss man position: sticky im css wegnehmen
                if (posTop < 0 && posTop + height - 10 != 0){
                    val.style.marginTop = "-" + (height + 30) + "px"    //bubble-height + posTop
                    val.style.marginBottom = (height + 30 + 50) + "px"  //bubble-height + posTop + initial MarginBottom
                } else if (posTop + height - 10 == 0){
                    console.log("Passt")
                    val.style.marginTop = "0px"
                    val.style.marginBottom = "50px"
                }  
            })
        })
    },
    
    setCharData: function (clicked, setWhat) {
        var fieldsArr = setWhat.split(" ")
        $("[for=" + clicked.getAttribute("name") + "]").each(function(key, val){
            GlobVars.Character[val.getAttribute("stat")] = $(val).val()
        })
        
        console.log(GlobVars.Character)
    },
    tellStory: function (container){
        container.firstChild.classList.add("show-dialog")
        container.firstChild.classList.remove("hide-dialog")
        
        document.getElementById("dialog-story-btn").addEventListener("click", function (){
            var FirstHideDialog = document.getElementsByClassName("hide-dialog")[0]        
            
            if (FirstHideDialog != undefined){
                FirstHideDialog.classList.add("show-dialog")
                FirstHideDialog.classList.remove("hide-dialog")
                window.scrollTo({top: scrollY + FirstHideDialog.offsetHeight + 50, behavior: "smooth"})
                
            } else {
                document.getElementById("dialog-story-btn").remove()
            }
        })
    }
}