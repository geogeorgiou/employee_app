
//function to call when submitting changes to password
function passValidator() {

    //we define a regular expression to accept
    //at least 1 char [a-z]
    //at least 1 char [A-Z]
    //at least 1 numeric [0-9]
    //at least 1 special char [!@#$%^&*]

    var $regexname = /^((?=.*[a-z])|(?=.*[A-Z]))(?=.*[!@#$%^&*.])(?=.*[0-9])[0-9a-zA-Z!@#$%^&*.]{8,}$/;

    var password = document.getElementById("password").value;

    //check if password matches regular expression format
    if ($regexname.test(password)){
        $('.emsg').addClass('hidden');
        return true;
    }

    //if invalid format; style password with red outline
    document.getElementById("password").style.border="2px solid red";

    $('.emsg').removeClass('hidden');
    $('.emsg').show();
    return false;

}
