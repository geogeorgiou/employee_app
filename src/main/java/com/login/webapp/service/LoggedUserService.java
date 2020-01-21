package com.login.webapp.service;

import com.login.webapp.domain.LoginUser;
import com.login.webapp.model.UserModel;

public interface LoggedUserService {

    //SEARCH

    UserModel findByEmail(String email);

    //UPDATE

    LoginUser updateUser(UserModel userModel);

    //CREATE

    LoginUser createUser(UserModel userModel);
}
