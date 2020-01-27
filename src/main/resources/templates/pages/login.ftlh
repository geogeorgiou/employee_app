<#--login page defined here-->

<!DOCTYPE html>
<html lang="en">
<head>

<#--    using bootstrap examples for login -->
    <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css">
    <link rel="stylesheet" type="text/css" href="css/login_styles.css">

    <title>Login</title>

<#--    adding partials which are common js,css etc to put in head-->
    <#include  "../partials/head.ftlh">

</head>
<body class="text-center">

<#--form that makes a POST in login to use SpringSecurity functionality -->
<form class="form-login needs-validation" action="/login"  id="user-login" method="POST">

    <#--    small icon to put in login-->
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
         stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mb-4">
        <rect x="3" y="3" width="18" height="18" rx="2" ry="2"></rect>
        <circle cx="8.5" cy="8.5" r="1.5"></circle>
        <polyline points="21 15 16 10 5 21"></polyline>
    </svg>

    <#--    login prompt-->
<#--    <h1 class="h3 mb-3 font-weight-normal">Login</h1>-->

    <#--    username div with necessary name value for Security-->
    <div class="mb-3">
        <div class="login_span"><span data-feather="user" class="login_icon"></span>username</div>

        <label for="username" class="sr-only">Email</label>
        <input type="email" name="username" id="username" class="form-control" required >
        <div class="invalid-feedback">
            Valid email is required.
        </div>
    </div>

    <#--    password div with necessary name value for Security-->

    <div class="mb-3">
        <div class="login_span"><span data-feather="lock" class="login_icon"></span>password</div>

        <label for="password" class="sr-only">Password</label>
        <input type="password" name="password" id="password" class="form-control" required>
        <div class="invalid-feedback">
            Password is required.
        </div>
    </div>

<#--    error message when invalid credentials are inserted-->
    <#if hasError>
        <div class="alert alert-danger login_error" role="alert">
             <p><span data-feather="alert-octagon" class="login_icon"></span>Invalid username or password!</p>
        </div>
    </#if>

<#--    submit btn-->
    <button class="btn btn-lg btn-primary btn-block mt-4" type="submit">
        Login<span data-feather="log-in" class="align-middle login_icon"></span>
    </button>

<#--    anchor link to register page-->
    <div class="register_anchor_container">
        <a class="register_anchor" href="/register">Have you registered yet?</a>
    </div>

</form>

<#--some  js to be include before /body-->
<#include "../partials/body.ftlh">

<script>
    feather.replace();
</script>

</body>
</html>

