package com.login.employee.mapper;

import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.model.EmployeeModel;
import org.springframework.stereotype.Component;

//Mapper class from User to UserModel Data

@Component
public class EmployeeToEmployeeModel {

    //assigns variables from User to User Model
    //basically DB data to plain String for web display
    public EmployeeModel mapToEmployeeModel(Employee emp){
        EmployeeModel empModel = new EmployeeModel();

        empModel.setId(emp.getId());
        empModel.setName(emp.getName());
        empModel.setDateOfHire(emp.getDateOfHire().toString()); //maybe needs formatter
        empModel.setSupervisor(emp.getSupervisor() != null ? emp.getSupervisor().getId() : "n/a"); //check for nullability

        //assign login related variables useless here?
        empModel.setEmail(emp.getEmail());
        empModel.setPassword(emp.getPassword());
        empModel.setRole(emp.getRole() != null ? emp.getRole() : RoleType.USER); //USER IS THE DEFAULT OPTION

        return empModel;

    }

}