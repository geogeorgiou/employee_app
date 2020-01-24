<form class="needs-validation" novalidate action="/admin/${employee.id}/edit" id="" method="POST">


    <div class="row">
        <#--        no changes here i Don't want the form to be able to pass this as argument-->
        <div class="col-md-6 mb-3">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="Enter id" value="${employee.id}" readonly>
        </div>

        <div class="col-md-6 mb-3">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter employee name" value="${employee.name}">
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="dateOfHire">Hire date</label>
            <input type="date" class="form-control" id="dateOfHire" name="dateOfHire" placeholder="Enter hire date" value="${employee.dateOfHire}">

        </div>
        <div class="col-md-6 mb-3">
            <label for="supervisor">Supervisor</label>
            <input type="text" class="form-control" id="supervisor" name="supervisor" placeholder="Enter supervisor" value="${employee.supervisor}">

        </div>
    </div>
</form>

