function isValidEmployee() {

    var p = document.getElementById("pError");

    if (p != null){

        var text = $(p).text();

        //if not empty error occurred!
        alert("not valid Employee");
        p.style.color = "red";
        return false;
        // if( text != "") {
        //     alert("not valid Employee");
        //     p.style.color = "red";
        //     return false;
        // }
    }
    alert("VALID");
    return true;

}
