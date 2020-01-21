package com.login.webapp.model;

import com.login.webapp.domain.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//LoginResponse necessary for SpringSecurity module
//to hold username, password and authorities

public class LoginResponse extends User {

    private LoginUser loginUser;

    public LoginResponse(String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities,
                         LoginUser loginUser) {
        super(username, password, authorities);
        this.loginUser = loginUser;
    }

    public LoginUser getLoginUser() {return loginUser;}


}


