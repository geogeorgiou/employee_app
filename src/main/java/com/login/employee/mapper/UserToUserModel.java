package com.login.employee.mapper;

import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.model.UserModel;
import org.springframework.stereotype.Component;

//Mapper class from User to UserModel Data

@Component
public class UserToUserModel {

    //assigns variables from User to User Model
    //basically DB data to plain String for web display
    public UserModel mapToUserModel(Employee user){
        UserModel userModel = new UserModel();

        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setDateOfHire(user.getDateOfHire().toString()); //maybe needs formatter
        userModel.setSupervisor(user.getSupervisor().getId()); //check for nullability

        //assign login related variables
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setRole(user.getRole() != null ? user.getRole() : RoleType.USER); //USER IS THE DEFAULT OPTION

        return userModel;

    }

}
