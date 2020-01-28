<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <title>Home page</title>
</head>
<body>
<#--<#include "../partials/userNavbar.ftlh">-->
<#--<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">-->
<#--    <div class="row">-->
<#--        <div class="col-md-12 order-md-1">-->
<#--            <#if role == "ADMIN">-->
<#--                <h2>Admin Page</h2>-->
<#--            <#elseif role == "USER">-->
<#--                <h2>Welcome ${userFirstName}!</h2>-->
<#--            </#if>-->

<#--            <#include "../forms/employeeTable.ftlh">-->

<#--        </div>-->
<#--    </div>-->
<#--</main>-->
<#if role == "ADMIN">
    <#include "../partials/adminNavbar.ftlh">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <div class="row">
            <div class="col-md-12 order-md-1">

                <h2>Admin Page</h2>

                <#include "../forms/employeeTable.ftlh">

            </div>
        </div>
    </main>
<#elseif role == "USER">
    <#include "../partials/userNavbar.ftlh">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <div class="row">
            <div class="col-md-12 order-md-1">

                <h2>Welcome ${userFirstName}!</h2>

                <#include "../forms/employeeTable.ftlh">

            </div>
        </div>
    </main>
</#if>


<#include "../partials/body.ftlh">
<script>
    feather.replace();
</script>
<script src="/js/validator.js"></script>
</body>
</html>