package com.login.webapp.domain;

import com.login.webapp.enums.RoleType;

import javax.persistence.*;


//Main Entity of the Web App

@Entity
@Table(name = "LOGIN_USER")
public class LoginUser {

    //Static variables
    private static final int MAX_PHONE_LENGTH = 10;

    //User variables

    //email is the ID of the DB
    //cannot be duplicate or null
    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "company")
    private String company;

    @Column(name = "phoneNumber", length = MAX_PHONE_LENGTH)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    //role is the attribute to distinguish if user
    //is admin or plain user
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleType role;

    public LoginUser() {
    }

    public LoginUser(String email,
                     String firstName,
                     String lastName,
                     String company,
                     String phoneNumber,
                     String password,
                     RoleType role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() { return role; }

    public void setRole(RoleType role) { this.role = role; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("email=").append(email);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
