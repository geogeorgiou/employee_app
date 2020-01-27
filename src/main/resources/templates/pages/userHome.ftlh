

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <title>Home page</title>
</head>
<body>
<#include "../partials/adminNavbar.ftlh">
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <#if role == "ADMIN">
                <h2>Admin Page</h2>
            <#elseif role == "USER">
                <h2>Welcome ${userFirstName}!</h2>
            </#if>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Hire Date</th>
                        <th class="text-center">Name</th>
                        <th class="text-center">Supervisor</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if employees??>
                        <#list employees as emp>
                            <tr data-id="${emp.id}">
                                <td><a href="/admin/${emp.id}/edit">#${emp.id}</a></td>
                                <td>${emp.dateOfHire}</td>
                                <td class="text-center">${emp.name}</td>
                                <td class="text-center">${emp.supervisor}</td>

                                <td class="text-center"><a class="btn btn-link" href="/admin/${emp.id}/edit"><span
                                                data-feather="tool"></span></a></td>
                                <td class="text-center">

                                    <button
                                            class="btn btn-link"
                                            data-toggle="modal"
                                            data-target="#modal"
                                            data-id="${emp.id}"
                                    >
                                        <span data-feather="x" style="color:red"></span>
                                    </button>

                                </td>

                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>

                <div id="modal" class="modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Employee</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p><strong>Are you sure?</strong>
                                <br>By deleting an employee all subordinates are deleted too!
                                </p>
                            </div>
                            <div class="modal-footer">
                                <form method="post" id="deleteForm">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</main>
<#include "../partials/body.ftlh">
<script>
    feather.replace();
</script>
<script src="/js/validator.js"></script>
</body>
</html>