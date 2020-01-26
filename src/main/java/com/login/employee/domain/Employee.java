package com.login.employee.domain;

import com.login.employee.enums.RoleType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Main Entity of the Web App

@Entity
@Table(name = "Employee")
public class Employee {


    //User variables

    @Id
    @Column(name = "EMP_ID",nullable = false)
    private String id;

    @Column(name = "EMP_Name")
    private String name;

    @Column(name = "EMP_Date_Of_Hire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfHire;

    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name="EMP_Supervisor")
    private Employee supervisor;

    @ManyToMany
    @JoinTable(
                name = "EmployeeAttribute",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTR_ID"))
    private List<Attribute> hasAttr;

    //used to find all subordinates of a supervisor

    @OneToMany(mappedBy="supervisor")
    private Set<Employee> subordinates; // = new HashSet<Employee>();

    //Login Credentials related attributes

    //nullable false ?
    @Column(name = "email")
    private String email;

    //nullable false ?
    @Column(name = "password")
    private String password;

    //nullable false ?
    //role is the attribute to distinguish if user
    //is admin or plain user
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

    public Employee() {
    }

    public Employee(String id, String name, LocalDate dateOfHire, Employee supervisor, String email, String password, RoleType role) {
        this.id = id;
        this.name = name;
        this.dateOfHire = dateOfHire;
        this.supervisor = supervisor;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public List<Attribute> getHasAttr() {
        return hasAttr;
    }

    public void setHasAttr(List<Attribute> hasAttr) {
        this.hasAttr = hasAttr;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
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
        sb.append("id=").append(id);
        sb.append(", Name='").append(name).append('\'');
        sb.append(", Date Of Hire='").append(dateOfHire).append('\'');
        sb.append(", Supervisor='").append(supervisor).append('\'');
        sb.append(", email=").append(email);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
