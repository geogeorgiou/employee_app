package com.login.employee.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Attribute")
public class Attribute {


    @Id
    @Column(name = "ATTR_ID",nullable = false)
    private String ATTR_ID;


    @Column(name = "ATTR_Name",nullable = false)
    private String ATTR_Name;

    @Column(name = "ATTR_Value",nullable = false)
    private String ATTR_Value;

    @ManyToMany(mappedBy = "hasAttr")
    List<Attribute> has;

    public Attribute() {
    }

    public Attribute(String ATTR_ID, String ATTR_Name, String ATTR_Value, List<Attribute> has) {
        this.ATTR_ID = ATTR_ID;
        this.ATTR_Name = ATTR_Name;
        this.ATTR_Value = ATTR_Value;
        this.has = has;
    }

    public String getATTR_ID() {
        return ATTR_ID;
    }

    public void setATTR_ID(String ATTR_ID) {
        this.ATTR_ID = ATTR_ID;
    }

    public String getATTR_Name() {
        return ATTR_Name;
    }

    public void setATTR_Name(String ATTR_Name) {
        this.ATTR_Name = ATTR_Name;
    }

    public String getATTR_Value() {
        return ATTR_Value;
    }

    public void setATTR_Value(String ATTR_Value) {
        this.ATTR_Value = ATTR_Value;
    }

    public List<Attribute> getHas() {
        return has;
    }

    public void setHas(List<Attribute> has) {
        this.has = has;
    }
}
