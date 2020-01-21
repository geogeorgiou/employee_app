package com.login.employee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeAttribute")
public class EmployeeAttribute {


    @Id
    @Column(name = "EMPATTR_EMP_ID",nullable = false)
    private String EMPATTR_EMP_ID;

    @Column(name = "EMPATTR_ATTR_ID")
    private String EMPATTR_ATTR_ID;

    @Column(name = "EMPATTR_ATTR_Name")
    private String EMPATTR_ATTR_Name;

    public EmployeeAttribute() {
    }

    public EmployeeAttribute(String EMPATTR_EMP_ID, String EMPATTR_ATTR_ID, String EMPATTR_ATTR_Name) {
        this.EMPATTR_EMP_ID = EMPATTR_EMP_ID;
        this.EMPATTR_ATTR_ID = EMPATTR_ATTR_ID;
        this.EMPATTR_ATTR_Name = EMPATTR_ATTR_Name;
    }

    public String getEMPATTR_EMP_ID() {
        return EMPATTR_EMP_ID;
    }

    public void setEMPATTR_EMP_ID(String EMPATTR_EMP_ID) {
        this.EMPATTR_EMP_ID = EMPATTR_EMP_ID;
    }

    public String getEMPATTR_ATTR_ID() {
        return EMPATTR_ATTR_ID;
    }

    public void setEMPATTR_ATTR_ID(String EMPATTR_ATTR_ID) {
        this.EMPATTR_ATTR_ID = EMPATTR_ATTR_ID;
    }

    public String getEMPATTR_ATTR_Name() {
        return EMPATTR_ATTR_Name;
    }

    public void setEMPATTR_ATTR_Name(String EMPATTR_ATTR_Name) {
        this.EMPATTR_ATTR_Name = EMPATTR_ATTR_Name;
    }



}
