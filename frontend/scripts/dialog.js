Dialog = {
    fillDialog: function (dialogContainer, character) {
        var container = document.getElementById(dialogContainer)
        container.style.willChange = "contents"
        character = character.split(" ").join("").toLowerCase()
        var html= BuildThis.dialog(GlobVars.Dialog[character])
        container.innerHTML = html
        container.style.willChange = "auto"
    },
    
    scroll: function () {
        console.log("Hallo")
    }
}