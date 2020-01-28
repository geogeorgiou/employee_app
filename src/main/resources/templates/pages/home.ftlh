<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <title>Home page</title>
</head>
<body>

<#if role == "ADMIN">
    <#include "../navBars/adminNavbar.ftlh">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <div class="row">
            <div class="col-md-12 order-md-1">

                <h2>Admin Page</h2>

                <#include "../forms/employeeTable.ftlh">

            </div>
        </div>
    </main>
<#elseif role == "USER">
    <#include "../navBars/userNavbar.ftlh">
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
<script src="/js/employeeValidator.js"></script>
</body>
</html>