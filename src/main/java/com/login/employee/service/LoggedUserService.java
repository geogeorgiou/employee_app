package com.login.employee.service;

import com.login.employee.domain.LoginUser;
import com.login.employee.model.UserModel;

public interface LoggedUserService {

    //SEARCH

    UserModel findByEmail(String email);

    //UPDATE

    LoginUser updateUser(UserModel userModel);

    //CREATE

    LoginUser createUser(UserModel userModel);
}
