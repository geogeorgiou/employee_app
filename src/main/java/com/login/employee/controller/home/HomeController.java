package com.login.employee.controller.home;


import com.login.employee.domain.Employee;
import com.login.employee.model.EmployeeModel;
import com.login.employee.model.LoginResponse;
import com.login.employee.repository.EmployeeRepository;
import com.login.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Controller that handles /user/home

@Controller
@RequestMapping("/admin")
public class HomeController {


    //variables to assign to Model and used in ftl

    //static variable relating to Employee
    private static final String EMPLOYEES_LIST = "employees";
    private static final String EMPLOYEE_ATTR = "employee";
    private static final String ERR_MSG = "errMsg";

    //static variables relating to webapp user
    private static final String LOGGED_USER_ATTR = "loggedUser";
    private static final String LOGGED_USER_NAME = "userFirstName";
    private static final String LOGGED_USER_ROLE = "role";

    //User Service
    @Autowired
    private EmployeeService employeeService;

    //DELETE AFTERWARDS!
    @Autowired
    private EmployeeRepository REPO;

    //GET of /user/home

    @GetMapping(value = "/home")
    public String getUserProfile(Model model) {

        //Handle details of currently authenticated user

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        LoginResponse loginResponse = (LoginResponse) contextHolder.getAuthentication().getPrincipal();

        Employee loginUser = loginResponse.getLoginUser();

        EmployeeModel userModel = employeeService.findByEmail(loginUser.getEmail());

        //Assign variables to model in order to show data on /user/home

        List<EmployeeModel> employeeModels = employeeService.findAll();

        model.addAttribute(EMPLOYEES_LIST, employeeModels);

        model.addAttribute(LOGGED_USER_ATTR, userModel);
        model.addAttribute(LOGGED_USER_NAME, loginUser.getName());
        model.addAttribute(LOGGED_USER_ROLE, loginUser.getRole().name());

        return "pages/userHome";
    }

    @GetMapping(value = "/{id}/edit")
    public String getEditEmployee(@PathVariable String id,Model model){

        EmployeeModel employeeModel = employeeService.findById(id);

        model.addAttribute(EMPLOYEE_ATTR,employeeModel);

        return "pages/editEmployee";
    }

    @PostMapping(value = "/{id}/edit")
    public String doEditEmployee(EmployeeModel employeeModel,Model model) {

        try{

            employeeService.updateEmployee(employeeModel);

        } catch (NullPointerException npe){

            //add to model error message for print? Doesn't show
            System.out.println(npe.getMessage());
            model.addAttribute(ERR_MSG,npe.getMessage());

            return "redirect:/admin/{id}/edit";
        }
        return "redirect:/admin/home";
    }

    @GetMapping(value = "/create")
    public String getCreateEmployee(Model model){
        model.addAttribute(EMPLOYEE_ATTR, new EmployeeModel());
        return "pages/createEmployee";
    }

    @PostMapping(value = "/create")
    public String doCreateEmployee(@ModelAttribute(EMPLOYEE_ATTR) EmployeeModel employeeModel){
        employeeService.createEmployee(employeeModel);
        return "redirect:/admin/home";
    }


    @PostMapping(value = "/{id}/delete")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteById(id);
        return "redirect:/admin/home";
    }





    //POST of /user/home
    //Handles the submitted form

//    @PostMapping(value = "/user/home")
//    public String postUserProfile(Model model,
//                                  @ModelAttribute(LOGGED_USER_ATTR) UserModel userForm) {
//
//        userForm.setRole(RoleType.USER);    //since we only have USER
//
//        model.addAttribute(LOGGED_USER_ATTR, userForm);
//        model.addAttribute(LOGGED_USER_NAME, userForm.getName());
//        model.addAttribute(LOGGED_USER_ROLE, userForm.getRole().name());
//
//
//        //updates user data
//        employeeService.updateUser(userForm);
//        return "redirect:/user/home";
//    }



}
