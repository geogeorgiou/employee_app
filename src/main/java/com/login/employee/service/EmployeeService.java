package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.model.UserModel;

public interface EmployeeService {

    //SEARCH

    UserModel findByEmail(String email);

    //UPDATE

    Employee updateUser(UserModel userModel);

    //CREATE

    Employee createUser(UserModel userModel);
}
