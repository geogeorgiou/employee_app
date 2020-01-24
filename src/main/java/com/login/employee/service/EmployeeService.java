package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //SEARCH
    Optional<Employee> findById(String id);

    EmployeeModel findByEmail(String email);

    List<EmployeeModel> findAll();

    //UPDATE

    Employee updateUser(EmployeeModel userModel);

    //CREATE

    Employee createUser(EmployeeModel userModel);
}
