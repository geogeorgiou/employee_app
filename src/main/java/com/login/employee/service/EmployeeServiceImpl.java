package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.mapper.EmployeeModelToEmployee;
import com.login.employee.mapper.EmployeeToEmployeeModel;
import com.login.employee.model.EmployeeModel;
import com.login.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
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

        //redundant here
//        Set<Employee> setemp = userRepo.findSubBySupervisorId(employee.get().getId());
//
//        Iterator<Employee> it = setemp.iterator();
//
//        while (it.hasNext())
//            System.out.println(it.next().getId());

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
    public Employee updateEmployee(EmployeeModel empModel) {

        String empId = empModel.getId();
        String superId = empModel.getSupervisor();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Employee emp = userRepo.findById(empId).get();

        emp.setId(empId); //readonly
        emp.setName(empModel.getName());
        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter));
        emp.setSupervisor(userRepo.findById(superId).get()); //readonly

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        String empId = empModel.getId();
//        String superId = empModel.getSupervisor();
//
//        emp.setId(empId); //is readonly
//        emp.setName(empModel.getName());
//        emp.setDateOfHire(LocalDate.parse(empModel.getDateOfHire(), dateTimeFormatter)); //maybe needs formatter
//
//        emp.setSupervisor(empRepo.findById(superId).get());

        return userRepo.save(emp);
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

        employee.setEmail("");
        employee.setRole(RoleType.ADMIN);
        employee.setPassword("");

        return userRepo.save(employee);

    }

    //UPDATE

    //update user data according to UserModel data
//    @Override
//    public LoginUser updateUser(UserModel userModel) {
//
//        //assign email to variable
//        String updatedEmail = userModel.getEmail();
//
//        //find User using Repository
//        //will not throw exception on duplicate mail because it will be a readonly field
//        LoginUser loginUser = userRepo.findByEmail(updatedEmail).get();
//
//        //assign variables to updatedUser
//        loginUser.setEmail(updatedEmail);
//        loginUser.setCompany(userModel.getCompany());
//        loginUser.setFirstName(userModel.getFirstName());
//        loginUser.setLastName(userModel.getLastName());
//        loginUser.setPhoneNumber(userModel.getPhoneNumber());
//        loginUser.setRole(userModel.getRole());
//
//        //ONLY ENCRYPT PASSWORD IF USER CHANGED IT
//        //otherwise it will encrypt the encrypted password (unwanted behaviour)
//        if (!(loginUser.getPassword().equals(userModel.getPassword()))) {
//
//            loginUser.setPassword(encoder.encode(userModel.getPassword()));
//
//        } else {
//
//            loginUser.setPassword(userModel.getPassword());
//
//        }
//
//        return userRepo.save(loginUser);
//    }

    //CREATE
    //creates user

//    @Override
//    public LoginUser createUser(UserModel userModel) throws DuplicateEmailException{
//
//        //assign mail to variable
//        String email = userModel.getEmail();
//
//        //find User using Repository
//        Optional<LoginUser> optionalLoginUser = userRepo.findByEmail(email);
//
//        //throws exception if duplicate mail is find in DB
//        if (!optionalLoginUser.isEmpty())
//            throw new DuplicateEmailException(email);
//
//        //assign variables
//        LoginUser loginUser = new LoginUser();
//        loginUser.setEmail(email);
//        loginUser.setFirstName(userModel.getFirstName());
//        loginUser.setLastName(userModel.getLastName());
//        loginUser.setCompany(userModel.getCompany());
//        loginUser.setPhoneNumber(userModel.getPhoneNumber());
//        loginUser.setRole(userModel.getRole());
//
//
//        //encrypt password before create
//        loginUser.setPassword(encoder.encode(userModel.getPassword()));
//        return userRepo.save(loginUser);
//    }


    @Override
    public void deleteById(String id) {
        userRepo.deleteById(id);
    }
}
