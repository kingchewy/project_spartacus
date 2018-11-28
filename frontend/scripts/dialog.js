Dialog = {
    fillDialog:  (dialogContainer, character) => {
        var container = document.getElementById(dialogContainer)
        container.style.willChange = "contents"
        character = character.split(" ").join("").toLowerCase()
        var html= BuildThis.dialog(GlobVars.Dialog[character])
        
        container.innerHTML = html
        container.style.willChange = "auto"
        Dialog.tellStory(container)
    },
    
    setCharData:  (clicked, setWhat) => {
        var fieldsArr = setWhat.split(" ")
        $(`[for=${clicked.getAttribute("name")}`).each((key, val) => {
            GlobVars.Character[val.getAttribute("stat")] = $(val).val()
        })
        console.log(GlobVars.Character)
    },
    
    tellStory:  container => {
        container.firstChild.classList.add("show-dialog")
        container.firstChild.classList.remove("hide-dialog")
        
        document.getElementById("dialog-story-btn").addEventListener("click", () => {
            var FirstHideDialog = document.getElementsByClassName("hide-dialog")[0]
            
            if (FirstHideDialog){
                FirstHideDialog.classList.add("show-dialog")
                FirstHideDialog.classList.remove("hide-dialog")
//                console.log(FirstHideDialog.offsetTop + FirstHideDialog.offsetHeight + 50, window.innerHeight)
                if (FirstHideDialog.offsetTop + FirstHideDialog.offsetHeight + 50 > window.innerHeight){
                    window.scrollTo({top: scrollY + FirstHideDialog.offsetHeight + 50, behavior: "smooth"})   
                }                
            } else {
                document.getElementById("dialog-story-btn").remove()
            }
        })
    }
}