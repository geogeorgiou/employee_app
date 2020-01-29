<#--    table to display contents if role is either admin or user-->

<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>ID</th>
            <th>Hire Date</th>
            <th class="text-center">Name</th>
            <th class="text-center">Supervisor</th>

            <#if role == "ADMIN">
                <th class="text-center">Edit</th>
                <th class="text-center">Remove</th>
            </#if>

        </tr>
        </thead>
        <tbody>
        <#if employees??>
            <#list employees as emp>
                <tr data-id="${emp.id}">
                    <td class="align-middle">${emp.id}</td>
                    <td class="align-middle">${emp.dateOfHire}</td>
                    <td class="text-center align-middle">${emp.name}</td>
                    <td class="text-center align-middle">${emp.supervisor}</td>

                    <#if role == "ADMIN">
                        <td class="text-center align-middle"><a class="btn btn-link" href="/admin/${emp.id}/edit"><span
                                        data-feather="tool"></span></a></td>
                        <td class="text-center align-middle">

                            <button
                                    class="btn btn-link"
                                    data-toggle="modal"
                                    data-target="#modal"
                                    data-id="${emp.id}"
                            >
                                <span data-feather="x" style="color:red"></span>
                            </button>

                        </td>
                    </#if>


                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <#if role == "ADMIN">
        <#include "../modal/employeDeleteModal.ftlh">
    </#if>

</div>