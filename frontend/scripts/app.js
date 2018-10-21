App = {
    opener: function () {
        document.getElementsByTagName("use")[0].addEventListener("animationend", function(){
            document.getElementsByClassName("stroke-1")[0].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-2")[0].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-3")[0].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-4")[0].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-1")[1].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-2")[1].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-3")[1].style.strokeWidth = "0px"
            document.getElementsByClassName("stroke-4")[1].style.strokeWidth = "0px"
            document.getElementById("opening").remove()
        })
        setTimeout(function(){
                document.body.style.backgroundPosition = "bottom"
        }, 1500)
    }
}