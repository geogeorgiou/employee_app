package com.login.employee.model;

import com.login.employee.domain.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//LoginResponse necessary for SpringSecurity module
//to hold username, password and authorities

public class LoginResponse extends User {

    private Employee loginUser;

    public LoginResponse(String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities,
                         Employee loginUser) {
        super(username, password, authorities);
        this.loginUser = loginUser;
    }

    public Employee getLoginUser() {return loginUser;}


}


