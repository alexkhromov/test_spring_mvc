function setContainerWidth() {

    document.getElementById("container").setAttribute("style", "width: " + screen.width - 40 + "px");
    document.getElementById("container").style.width = screen.width - 40 + "px";
}

function setTitle(){

    var title = "";

    if ( window.location.pathname.toLowerCase().indexOf( "pages.html" ) != -1 )
        title = "Pages";
    else
        title = "Page Detail";

    document.title = title;
}
