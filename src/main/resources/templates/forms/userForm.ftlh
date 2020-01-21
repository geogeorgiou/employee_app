
<#--user form is defined here-->
<#--this form is used when logged in for data display and edit-->

<#--uses passValidator on submit to check password format-->

 <form class="needs-validation" action="/user/home" id="userValidator" method="POST" onsubmit="return passValidator();">


    <#--    row with first and last name input-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter first name" value="${loggedUser.firstName}" required>
        </div>

        <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter last name" value="${loggedUser.lastName}" required>
        </div>

    </div>

    <#--    row with email and phone input-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" value="${loggedUser.email}" readonly>
        </div>

        <div class="col-md-6 mb-3">
            <label for="phoneNumber">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number" value="${loggedUser.phoneNumber}">
        </div>

    </div>

    <#--    row with company-->
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="company">Company</label>
            <input type="text" class="form-control" id="company" name="company" placeholder="Enter Company" value="${loggedUser.company}">
        </div>
    </div>

    <#--    row with password-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" value="${loggedUser.password}" required>

            <p><span class="emsg hidden">at least 1 ([a-z] and/or [A-Z]), 1 numeric [0-9], a special char and at least 8 char total</span></p>
        </div>

    </div>


    <#--    submit button-->

    <div class="col-md-6 order-md-1">
        <div class="row">
            <button class="btn btn-primary btn-lg mt-4" type="submit" >Submit Changes</button>&nbsp&nbsp&nbsp
        </div>
    </div>
</form>