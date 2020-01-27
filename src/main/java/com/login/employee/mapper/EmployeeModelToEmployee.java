package com.login.employee.mapper;

import com.login.employee.domain.Employee;
import com.login.employee.model.EmployeeModel;
import com.login.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EmployeeModelToEmployee {

    //we use repo here so to not make some
    @Autowired
    private EmployeeRepository empRepo;

    public Employee toEmployee(EmployeeModel empModel){
        Employee emp = new Employee();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String empId = empModel.getId();
        String superId = empModel.getSupervisor();

        emp.setId(empId); //is readonly
        emp.setName(empModel.getName());
        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter)); //maybe needs formatter

        emp.setSupervisor(empRepo.findById(superId).get()); //is readonly

        return emp;

    }
}
