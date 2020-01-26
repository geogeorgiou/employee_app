package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.exception.CyclicChildException;
import com.login.employee.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //SEARCH
    EmployeeModel findById(String id);

    EmployeeModel findByEmail(String email);

    List<EmployeeModel> findAll();

    //UPDATE

    Employee updateEmployee(EmployeeModel empModel) throws CyclicChildException;

    //CREATE

    Employee createEmployee(EmployeeModel empModel);

    //DELETE

    void deleteById(String id);
}
