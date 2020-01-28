
<#--register form is defined here-->

<#--on submit will be directed to /register with POST-->
<#--on cancel will be directed to /login-->

<#--uses passValidator on submit to check password format-->

<form class="needs-validation" action="/register" id="userForm" method="POST">

<#--    row with first and last name input-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="logName">Name</label>
            <input type="text" class="form-control" id="logName" name="logName" placeholder="Enter name" required>
        </div>

        <div class="col-md-6 mb-3">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>

            <#--            duplicate mail error message here-->
            <#if duplicateMail??>
                <div>
                    <p style="color:red;">
                        ${duplicateMail}
                    </p>
                </div>
            </#if>

        </div>

    </div>

    <#--    row with password-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
        </div>

<#--        role div here-->
        <div class="col-md-6 mb-3">
            <label for="userRole">Role</label>
            <select class="custom-select d-block w-100" id="role" name="role">
                <#if userRoles??>
                    <#list userRoles as role>
                        <option value="${role}">${role}</option>
                    </#list>
                </#if>
            </select>
        </div>

    </div>

    <#-- button and cancel buttons-->
    <div class="col-md-6 order-md-1">
        <div class="row">
            <button class="btn btn-success btn-lg mt-4" type="submit">Register</button>&nbsp&nbsp&nbsp

            <button class="btn btn-danger btn-lg mt-4" type="submit" id="cancelBtn"><span data-feather="x-circle"></span> Cancel</button>&nbsp&nbsp&nbsp
        </div>
    </div>
</form>