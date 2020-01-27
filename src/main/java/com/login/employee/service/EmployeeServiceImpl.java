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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //UserRepository to retrieve data
    @Autowired
    private EmployeeRepository userRepo;

    //mapper to map DB data to Model data
    @Autowired
    private EmployeeToEmployeeModel employeeModelMapper;

    @Autowired
    private EmployeeModelToEmployee employeeMapper;

    //BCrypt encoder for password encryption
    @Autowired
    private PasswordEncoder encoder;

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


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Employee emp = userRepo.findById(empId).get();

        emp.setId(empId); //readonly
        emp.setName(empModel.getName());
        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter));

        String superId = empModel.getSupervisor();
        emp.setSupervisor(getEmployeeSupervisor(empId,superId));

//        String superId = empModel.getSupervisor();
//
//        //check for null cases (null,""," ") in superId (wanted no supervision)
//        if (superId.isBlank()){
//            emp.setSupervisor(null); //assign null employee
//            return userRepo.save(emp);
//        }
//
//        //supervision cases
//
//        Optional<Employee> foundSupervisor = userRepo.findById(superId);
//
//        if (foundSupervisor.isPresent()){
//
//            //case 1
//            //cannot have as supervisor himself!
//
//            //case 2
//            //has supervisor as descendant
//            //check if superId exists in empId subordinates
//            //exception doesn't check if parent is at lower level of hierarchy to child
//            //that means we can set a low-tier parent and instantly demote an employee
//
//            if (superId.equals(empId) || existsInSubordinateSet(empId,superId)){
//                //throws error cyclic reference exception
////                throw new CyclicChildException("Cyclic child-parent reference between " + empId + " and "+superId);
//                throw new CyclicChildException(empId,superId);
//            }
//
//
//
//
//        } else {
//            //cannot find supervisor?
//            //throw null pointer exception!
////            System.out.println("No such supervisor Id");
//            throw new NullPointerException("Supervisor with "+superId+" id doesn't exist!");
//
//        }
//
//        //reach this code only if pass all cases of exceptions
//        emp.setSupervisor(foundSupervisor.get());
        return userRepo.save(emp);
    }

    public boolean existsInSubordinateSet(String empId,String superId){
        Set<Employee> employeeSet = userRepo.findSubBySupervisorId(empId);

        Iterator<Employee> it = employeeSet.iterator();
        boolean exists = false;

        while (it.hasNext()){
            if (it.next().getId().equals(superId))
                exists = true;
        }

        return exists;
    }

    @Override
    public Employee createEmployee(EmployeeModel empModel) {
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

    public Employee getEmployeeSupervisor(String empId,String superId) throws NullPointerException,CyclicChildException{
//        String superId = empModel.getSupervisor();

        //check for null cases (null,""," ") in superId (wanted no supervision)
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
            throw new NullPointerException("Supervisor with "+superId+" id doesn't exist!");

        }

        //reach this code only if pass all cases of exceptions

        return foundSupervisor.get();
    }


    @Override
    public void deleteById(String id) {
        userRepo.deleteById(id);
    }
}
