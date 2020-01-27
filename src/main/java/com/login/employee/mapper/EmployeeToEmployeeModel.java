package com.login.employee.mapper;

import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

//Mapper class from User to UserModel Data

@Component
public class EmployeeToEmployeeModel {

    //assigns variables from User to User Model
    //basically DB data to plain String for web display
    public EmployeeModel ToEmployeeModel(Employee emp){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        EmployeeModel empModel = new EmployeeModel();

        empModel.setId(emp.getId());
        empModel.setName(emp.getName());
        empModel.setDateOfHire(dateTimeFormatter.format(emp.getDateOfHire())); //maybe needs formatter
        empModel.setSupervisor(emp.getSupervisor() != null ? emp.getSupervisor().getId() : "n/a"); //check for nullability

        return empModel;

    }

}
