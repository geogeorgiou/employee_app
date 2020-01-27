package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.domain.LoginUser;
import com.login.employee.enums.RoleType;
import com.login.employee.mapper.LoginUserToLoginUserModel;
import com.login.employee.model.EmployeeModel;
import com.login.employee.model.LoginUserModel;
import com.login.employee.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserRepository userRepo;

    @Autowired
    private LoginUserToLoginUserModel mapper;

    @Override
    public LoginUserModel findByEmail(String email){

        //needs some exception handling here if exists etc
        Optional<LoginUser> user = userRepo.findByEmail(email);
        return mapper.toLoginUserModel(user.get());
    }

    @Override
    public LoginUser createUser(LoginUserModel userModel) {

        LoginUser loginUser = new LoginUser();

        loginUser.setEmail(userModel.getEmail());
        loginUser.setRole(userModel.getRole() != null ? userModel.getRole() : RoleType.USER);
        loginUser.setPassword(userModel.getPassword());
        loginUser.setLogname(userModel.getLogName());

        return userRepo.save(loginUser);

    }
}
