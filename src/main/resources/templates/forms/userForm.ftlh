
<#--user form is defined here-->
<#--this form is used when logged in for data display and edit-->

<#--uses passValidator on submit to check password format-->

 <form class="needs-validation" action="/user/home" id="" method="POST" onsubmit="">


    <#--    row with first and last name input-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="Enter id" value="${loggedUser.id}">
        </div>

        <div class="col-md-6 mb-3">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" value="${loggedUser.name}">
        </div>


    </div>

    <#--    row with email and phone input-->
    <div class="row">

        <div class="col-md-6 mb-3">
            <label for="dateOfHire">Email</label>
            <input type="date" class="form-control" id="dateOfHire" name="dateOfHire" placeholder="Enter date" value="${loggedUser.dateOfHire}">
        </div>

        <div class="col-md-6 mb-3">
            <label for="supervisor">Supervisor</label>
            <input type="text" class="form-control" id="supervisor" name="supervisor" placeholder="Enter supervisor" value="${loggedUser.supervisor}">
        </div>

    </div>


    <#--    submit button-->

    <div class="col-md-6 order-md-1">
        <div class="row">
            <button class="btn btn-primary btn-lg mt-4" type="submit" >Submit Changes</button>&nbsp&nbsp&nbsp
        </div>
    </div>
</form>