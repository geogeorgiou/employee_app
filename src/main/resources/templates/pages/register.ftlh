<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>


    <#--    adding partials which are common js,css etc to put in head-->
    <#include  "../partials/head.ftlh">
    <title>Register</title>

</head>
<body>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">

    <a class="navbar-brand col-sm-3 col-md-2 mr-0">

        <span>Register Page</span>
    </a>

</nav>

<div class="container-fluid">

<#--    Some elements to make the Webapp better aesthetically-->
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">

            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2>Register info:</h2>

<#--            register form inserted here-->
            <#include "../forms/registerForm.ftlh">

        </main>
    </div>
</div>

<#--some  js to be include before /body-->
<#include "../partials/body.ftlh">

<script>
    feather.replace();
</script>

<#--bypasses validation and redirects to login-->
<script type="text/javascript">
    document.getElementById("cancelBtn").onclick = function () {
        location.href = "/login";
    };
</script>

<#--scripts for validation of input fields-->
<script src="js/validator.js"></script>

</body>
</html>


