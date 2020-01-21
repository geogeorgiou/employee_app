package com.login.employee.mapper;

import com.login.employee.domain.LoginUser;
import com.login.employee.enums.RoleType;
import com.login.employee.model.UserModel;
import org.springframework.stereotype.Component;

//Mapper class from User to UserModel Data

@Component
public class UserToUserModel {

    //assigns variables from User to User Model
    //basically DB data to plain String for web display
    public UserModel mapToUserModel(LoginUser user){
        UserModel userModel = new UserModel();

        userModel.setId(user.getEMP_ID());
        userModel.setName(user.getEMP_Name());
        userModel.setDateOfHire(user.getEMP_Date_Of_Hire().toString()); //maybe needs formatter
        userModel.setSupervisor(user.getEMP_Supervisor());

        //assign login related variables
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setRole(user.getRole() != null ? user.getRole() : RoleType.USER); //USER IS THE DEFAULT OPTION

        return userModel;

    }

}
