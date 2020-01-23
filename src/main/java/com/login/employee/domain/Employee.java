package com.login.employee.domain;

import com.login.employee.enums.RoleType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


//Main Entity of the Web App

@Entity
@Table(name = "Employee")
public class Employee {

    //Static variables
//    private static final int MAX_PHONE_LENGTH = 10;

    //User variables

    @Id
    @Column(name = "EMP_ID",nullable = false)
    private String id;

    @Column(name = "EMP_Name")
    private String name;

    @Column(name = "EMP_Date_Of_Hire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfHire;

    @ManyToOne(optional = true, cascade=CascadeType.ALL)
    @JoinColumn(name="EMP_Supervisor")
    private Employee supervisor;

    @ManyToMany
    @JoinTable(
                name = "EmployeeAttribute",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTR_ID"))
    private List<Attribute> hasAttr;

    //Login Credentials related attributes

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    //role is the attribute to distinguish if user
    //is admin or plain user
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleType role;

    public Employee() {
    }

    public Employee(String EMP_ID, String EMP_Name, LocalDate EMP_Date_Of_Hire, Employee EMP_Supervisor, List<Attribute> hasAttr, String email, String password, RoleType role) {
        this.EMP_ID = EMP_ID;
        this.EMP_Name = EMP_Name;
        this.EMP_Date_Of_Hire = EMP_Date_Of_Hire;
        this.EMP_Supervisor = EMP_Supervisor;
        this.hasAttr = hasAttr;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(String EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getEMP_Name() {
        return EMP_Name;
    }

    public void setEMP_Name(String EMP_Name) {
        this.EMP_Name = EMP_Name;
    }

    public LocalDate getEMP_Date_Of_Hire() {
        return EMP_Date_Of_Hire;
    }

    public void setEMP_Date_Of_Hire(LocalDate EMP_Date_Of_Hire) {
        this.EMP_Date_Of_Hire = EMP_Date_Of_Hire;
    }

    public Employee getEMP_Supervisor() {
        return EMP_Supervisor;
    }

    public void setEMP_Supervisor(Employee EMP_Supervisor) {
        this.EMP_Supervisor = EMP_Supervisor;
    }

    public List<Attribute> getHasAttr() {
        return hasAttr;
    }

    public void setHasAttr(List<Attribute> hasAttr) {
        this.hasAttr = hasAttr;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(EMP_ID);
        sb.append(", Name='").append(EMP_Name).append('\'');
        sb.append(", Date Of Hire='").append(EMP_Date_Of_Hire).append('\'');
        sb.append(", Supervisor='").append(EMP_Supervisor).append('\'');
        sb.append(", email=").append(email);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
