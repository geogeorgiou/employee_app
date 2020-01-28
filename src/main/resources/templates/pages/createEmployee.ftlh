<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <title>Edit Employee</title>
</head>
<body>
<#include "../partials/pageNavbar.ftlh">
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <h4 class="mb-3">Create Employee</h4>
            <#include "../forms/createEmployeeForm.ftlh">
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