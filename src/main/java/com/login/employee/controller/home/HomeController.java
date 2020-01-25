package com.login.employee.controller.home;


import com.login.employee.domain.Employee;
import com.login.employee.model.EmployeeModel;
import com.login.employee.model.LoginResponse;
import com.login.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Controller that handles /user/home

@Controller
@RequestMapping("/admin")
public class HomeController {


    //variables to assign to Model and used in ftl

    //static variable relating to
    private static final String EMPLOYEES_LIST = "employees";
    private static final String EMPLOYEE_ATTR = "employee";

    //static variables relating to webapp user
    private static final String LOGGED_USER_ATTR = "loggedUser";
    private static final String LOGGED_USER_NAME = "userFirstName";
    private static final String LOGGED_USER_ROLE = "role";

    //User Service
    @Autowired
    private EmployeeService employeeService;

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

    @PostMapping(value = "/{id}")
    public String doEditEmployee(@PathVariable String id, EmployeeModel employeeModel) {
        employeeService.updateEmployee(employeeModel);
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
