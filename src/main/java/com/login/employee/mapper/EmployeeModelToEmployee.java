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

    public Employee ToEmployee(EmployeeModel empModel){
        Employee emp = new Employee();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String empId = empModel.getId();
        String superId = empModel.getSupervisor();

        emp.setId(empId); //is readonly
        emp.setName(empModel.getName());
        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter)); //maybe needs formatter

        emp.setSupervisor(empRepo.findById(superId).get()); //is readonly

//        emp.setSupervisor(new Employee());

//        emp.setSupervisor(!empModel.getSupervisor().isEmpty() ? empModel.getSupervisor() : "n/a"); //check for nullability

//        Optional<Employee> foundSupervisor = empRepo.findById(superId);
//
//        Set<Employee> empSet = empRepo.findSubBySupervisorId(empId);
//
//        Iterator<Employee> it = empSet.iterator();
//
//        while (it.hasNext())
//            System.out.println(it);

        //supervisor cases



        //should be executed last since he may had a supervisor before!
//        if (foundSupervisor.isEmpty())
//            emp.setSupervisor(new Employee()); //assign empty employee

//        if (empModel.getSupervisor().isEmpty()) {
//            emp.setSupervisor(new Employee());
//        }


//        if (empId.equals(superId)) {
//            //throw exception and error
//        }

        //must be updated when entering the update page
//        Set<Employee> empSet = foundSupervisor.get().getSubordinates();




        //NON-VALID
        //case 1: employee cannot have as supervisor himself
        //case 2: employee cannot have himself or his supervisor as subordinate
        //case 3: employee cannot have as supervisor someone who doesn't exist!

        //assign login related variables useless here?
//        emp.setEmail(empModel.getEmail());
//        emp.setPassword(empModel.getPassword());
//        emp.setRole(empModel.getRole() != null ? emp.getRole() : RoleType.USER); //USER IS THE DEFAULT OPTION

        return emp;

    }
}
