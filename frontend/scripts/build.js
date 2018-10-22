BuildThis = {
    dialog: function (speakerAndQuote){
        var html = ""
        speakerAndQuote.forEach(function (val, key) {
            if (val[0] == "N"){
                html += "<div class='narrator-bubble'><div>" + val[1] + "</div></div>\n"
            } else if (val[0] == "Y"){
                html += "<div class='you-bubble'><div>" + val[1] + "</div></div>\n"                
            }
        })
        return html
    }
}