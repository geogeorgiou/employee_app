package com.login.employee.service;

import com.login.employee.domain.LoginUser;
import com.login.employee.model.LoginUserModel;

public interface LoginUserService {

    LoginUserModel findByEmail(String email);

    LoginUser createUser(LoginUserModel userModel);

}
