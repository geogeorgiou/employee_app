package com.login.employee.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Attribute")
public class Attribute {


    @Id
    @Column(name = "ATTR_ID",nullable = false)
    private String id;


    @Column(name = "ATTR_Name",nullable = false)
    private String name;

    @Column(name = "ATTR_Value",nullable = false)
    private String value;

    @ManyToMany(mappedBy = "hasAttr")
    private List<Employee> has;

    public Attribute() {
    }

    public Attribute(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Employee> getHas() {
        return has;
    }

    public void setHas(List<Employee> has) {
        this.has = has;
    }
}
