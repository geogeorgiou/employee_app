<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <title>Edit Employee</title>
</head>
<body>
<#include "../partials/adminNavbar.ftlh">
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <h4 class="mb-3">Edit Employee</h4>
            <#include "../forms/editEmployeeForm.ftlh">
        </div>
    </div>
</main>
<#include "../partials/body.ftlh">
<script>
    feather.replace();
</script>


<#--<script src="/js/validEmployee.js"></script>-->

</body>
</html>