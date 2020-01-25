<form class="needs-validation" novalidate action="/admin/create" id="" method="POST">


    <div class="row">
        <#--        no changes here i Don't want the form to be able to pass this as argument-->
        <div class="col-md-6 mb-3">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="Enter id">
        </div>

        <div class="col-md-6 mb-3">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter employee name">
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="dateOfHire">Hire date</label>
            <input type="date" class="form-control" id="dateOfHire" name="dateOfHire" placeholder="Enter hire date">

        </div>
        <div class="col-md-6 mb-3">
            <label for="supervisor">Supervisor</label>
            <input type="text" class="form-control" id="supervisor" name="supervisor" placeholder="Enter supervisor">

        </div>
    </div>

    <div class="col-md-6 order-md-1">
        <div class="row">
            <button class="btn btn-primary btn-lg mt-4" type="submit" >Submit</button>&nbsp&nbsp&nbsp
            <span id="buttonAppear"></span>
        </div>
        <br><br><br>
    </div>
</form>

