package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.exception.CyclicChildException;
import com.login.employee.mapper.EmployeeModelToEmployee;
import com.login.employee.mapper.EmployeeToEmployeeModel;
import com.login.employee.model.EmployeeModel;
import com.login.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //UserRepository to retrieve data
    @Autowired
    private EmployeeRepository userRepo;

    //mapper to map DB data to Model data
    @Autowired
    private EmployeeToEmployeeModel employeeModelMapper;

//    @Autowired
//    private EmployeeModelToEmployee employeeMapper;
//
//    //BCrypt encoder for password encryption
//    @Autowired
//    private PasswordEncoder encoder;

    //SEARCH

    //using Repository that extends JPA to find User By Email
    //then map it to Model


    @Override
    public EmployeeModel findById(String id) {
        Optional<Employee> employee = userRepo.findById(id);

        return employeeModelMapper.ToEmployeeModel(employee.get());
    }

    @Override
    public EmployeeModel findByEmail(String email){

        //needs some exception handling here if exists etc
        Optional<Employee> employee = userRepo.findByEmail(email);
        return employeeModelMapper.ToEmployeeModel(employee.get());
    }

    @Override
    public List<EmployeeModel> findAll() {
        return userRepo
                .findAll()
                .stream()
                .map(employee -> employeeModelMapper.ToEmployeeModel(employee))
                .collect(Collectors.toList());
    }

    //AUTO GENERATED
    @Override
    public Employee updateEmployee(EmployeeModel empModel) throws NullPointerException,CyclicChildException {

        String empId = empModel.getId();

        Optional<Employee> optionalEmployee = userRepo.findById(empId);

        if (!optionalEmployee.isPresent())
            throw new NullPointerException("Employee with id={"+empId+"} doesn't exist!");

        Employee emp = optionalEmployee.get();

        setEmployeeVars(emp,empModel);

        return userRepo.save(emp);
    }

    public boolean existsInSubordinateSet(String empId,String superId){
        List<Employee> employeeSet = userRepo.findSubBySupervisorId(empId);

        Iterator<Employee> it = employeeSet.iterator();
        boolean exists = false;

        while (it.hasNext()){
            if (it.next().getId().equals(superId))
                exists = true;
        }

        return exists;
    }

    @Override
    public Employee createEmployee(EmployeeModel empModel) throws NullPointerException,CyclicChildException{
        Employee emp = new Employee();

        String empId = empModel.getId();

        Optional<Employee> optionalEmployee = userRepo.findById(empId);

        if (optionalEmployee.isPresent())
            throw new NullPointerException("Employee with id={"+empId+"} already exists!");

        setEmployeeVars(emp,empModel);

        return userRepo.save(emp);
    }

    //common code for {CREATE},{EDIT} Employee
    public void setEmployeeVars(Employee emp,EmployeeModel empModel) throws NullPointerException,CyclicChildException{

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String empId = empModel.getId();

        emp.setId(empId);
        emp.setName(empModel.getName());
        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter));

        String superId = empModel.getSupervisor();
        emp.setSupervisor(getEmployeeSupervisor(empId,superId));
    }

    //code to get Employee supervisor according to different scenarios
    public Employee getEmployeeSupervisor(String empId,String superId) throws NullPointerException,CyclicChildException{

        //check for null cases (null,""," ") in superId (no supervision)
        if (superId.isBlank())
            return null;

        //supervision cases

        Optional<Employee> foundSupervisor = userRepo.findById(superId);

        if (foundSupervisor.isPresent()){

            //case 1
            //cannot have as supervisor himself!

            //case 2
            //has supervisor as descendant
            //check if superId exists in empId subordinates
            //exception doesn't check if parent is at lower level of hierarchy to child
            //that means we can set a low-tier parent and instantly demote an employee

            if (superId.equals(empId) || existsInSubordinateSet(empId,superId)){
                //throws error cyclic reference exception
                throw new CyclicChildException(empId,superId);
            }

        } else {
            //cannot find supervisor?
            //throw null pointer exception!
            throw new NullPointerException("Supervisor with id={"+superId+"} doesn't exist!");

        }

        //reach this code only if pass all cases of exceptions

        return foundSupervisor.get();
    }


    @Override
    public void deleteById(String id) {

        //NEEDS SOME WORK
        //maybe refactor work to list?
        //delete by Id deletes all Subordinates
        List<Employee> employeeList = userRepo.findSubBySupervisorId(id);

        Collections.reverse(employeeList);

        for (Employee emp : employeeList) {
            userRepo.deleteById(emp.getId());
        }

        userRepo.deleteById(id);
    }

    @Override
    public Employee createUser(EmployeeModel empModel) {
        Employee employee = new Employee();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        employee.setId(empModel.getId());
        //exists? not himself?
        employee.setSupervisor(userRepo.findById(empModel.getSupervisor()).get());
        employee.setName(empModel.getName());
        employee.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter));

//        employee.setEmail("");
//        employee.setRole(RoleType.ADMIN);
//        employee.setPassword("");

        return userRepo.save(employee);

    }

}
