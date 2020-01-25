<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>

    <#--    adding partials which are common js,css etc to put in head-->
    <#include  "../partials/head.ftlh">
    <title>Home</title>

</head>
<body>



<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">

    <a class="navbar-brand col-sm-3 col-md-2 mr-0">


    </a>

    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">

<#--            logout option that is not available in register-->
<#--            since register doesn't need authorization-->
            <a class="nav-link" href="/logout">Logout</a>

        </li>
    </ul>
</nav>


<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">

            </div>
        </nav>

<#--        main part of page that checks for User role and displays data accordingly-->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <#if role == "ADMIN">
                <h2>Admin Page</h2>
            <#elseif role == "USER">
                <h2>Welcome ${userFirstName}!</h2>
            </#if>

            <div class="table-responsive"   id="emptyList">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Hire Date</th>
                        <th>Name</th>
                        <th>Supervisor</th>
                        <th>Edit</th>
                        <th>Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if employees??>
                        <#list employees as emp>
                            <tr data-id="1">
                                <td>${emp.id}</td>
                                <td>${emp.dateOfHire}</td>
                                <td>${emp.name}</td>
                                <td>${emp.supervisor}</td>
                                <td>
                                    <a href="/admin/${emp.id}/edit">
                                        <span data-feather="tool"></span>
                                    </a>
                                </td>
                                <td>
                                    <form action="/admin/${emp.id}/delete" method="post" style="display: inline;" id="form_box">
                                        <button type="submit" class="btn btn-danger delete_icon"><span data-feather="x"></span></button>
                                    </form>
                                </td>

                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>

        </main>
    </div>
</div>

<#--some  js to be include before /body-->
<#include "../partials/body.ftlh">

<script>
    feather.replace();
</script>


<#--scripts for validation of input fields + password-->
<#--<script src="/js/passValidator.js"></script>-->
<#--<script src="/js/validator.js"></script>-->

</body>
</html>


