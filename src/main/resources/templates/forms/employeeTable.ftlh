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
                    <td><a href="/admin/${emp.id}/edit">${emp.id}</a></td>
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

    <#include "../modal/employeDeleteModal.ftlh">

</div>