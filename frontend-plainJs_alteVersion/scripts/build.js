BuildThis = {
    dialog: speakerAndQuote => {
        var html = ""
        speakerAndQuote.forEach((val, key) => {
            if (val[0] == "N"){
                html += `<div class='narrator-bubble hide-dialog'><div>${val[1]}</div></div>\n`
            } else if (val[0] == "Y"){
                html += `<div class='you-bubble hide-dialog'><div>${val[1]}</div></div>\n`                
            }
        })
        html += "<button id='dialog-story-btn'>Onward</button>"
        return html
    }
}