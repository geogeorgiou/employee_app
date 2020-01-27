package com.login.employee.mapper;

import com.login.employee.domain.LoginUser;
import com.login.employee.enums.RoleType;
import com.login.employee.model.LoginUserModel;
import org.springframework.stereotype.Component;

@Component
public class LoginUserToLoginUserModel {

    public LoginUserModel toLoginUserModel(LoginUser loginUser){
        LoginUserModel userModel = new LoginUserModel();

        userModel.setLogName(loginUser.getLogname());
        userModel.setEmail(loginUser.getEmail());
        userModel.setPassword(loginUser.getPassword());
        userModel.setRole(loginUser.getRole() != null ? loginUser.getRole() : RoleType.USER); //USER IS THE DEFAULT OPTION

        return userModel;
    }
}
