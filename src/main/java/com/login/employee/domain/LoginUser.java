package com.login.employee.domain;

import com.login.employee.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = "LoginUser")
public class LoginUser {

    @Id
    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

    @Column(name = "logName",nullable = false)
    private String logname;

    public LoginUser() {
    }

    public LoginUser(String email, String password, RoleType role, String logname) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.logname = logname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }
}
