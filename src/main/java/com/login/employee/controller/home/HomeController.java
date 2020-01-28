package com.login.employee.controller.home;


import com.login.employee.domain.LoginUser;
import com.login.employee.enums.RoleType;
import com.login.employee.exception.CyclicChildException;
import com.login.employee.model.EmployeeModel;
import com.login.employee.model.LoginResponse;
import com.login.employee.model.LoginUserModel;
import com.login.employee.service.EmployeeService;
import com.login.employee.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller that handles /user/home

@Controller
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

    @Autowired
    private LoginUserService loginService;


    @GetMapping(value = "/user/home")
    public String getUserHome(Model model) {
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        LoginResponse loginResponse = (LoginResponse) contextHolder.getAuthentication().getPrincipal();

        LoginUser loginUser = loginResponse.getLoginUser();
        LoginUserModel userModel = loginService.findByEmail(loginUser.getEmail());

        //Assign variables to model in order to show data on /user/home

        List<EmployeeModel> employeeModels = employeeService.findAll();

        model.addAttribute(EMPLOYEES_LIST, employeeModels);

        model.addAttribute(LOGGED_USER_ATTR, userModel);
        model.addAttribute(LOGGED_USER_NAME, loginUser.getLogname());
        model.addAttribute(LOGGED_USER_ROLE, loginUser.getRole().name());
        return "pages/home";
    }

    @GetMapping(value = "/admin/home")
    public String getAdminHome(Model model){
        List<EmployeeModel> employees = employeeService.findAll();
        model.addAttribute(EMPLOYEES_LIST, employees);
        model.addAttribute("role", RoleType.ADMIN.name());
        return "pages/home";
    }

    //**************** EMPLOYEE CONTROLLER

    @GetMapping(value = "/admin/{id}/edit")
    public String getEditEmployee(@PathVariable String id,
                                  Model model){

        EmployeeModel employeeModel = employeeService.findById(id);

        model.addAttribute(EMPLOYEE_ATTR,employeeModel);

        return "pages/editEmployee";
    }

    @PostMapping(value = "/admin/{id}/edit")
    public String doEditEmployee(@ModelAttribute(EMPLOYEE_ATTR) EmployeeModel employeeModel,
                                 Model model) {

        try{

            employeeService.updateEmployee(employeeModel);

            //both nullpointer (cannot find supervisor) and (cyclic reference) are of identical behaviour
        } catch (NullPointerException | CyclicChildException ex){

            //add to model error message for print? Doesn't show
            System.out.println(ex.getMessage());
            model.addAttribute(ERR_MSG,ex.getMessage());

            return "redirect:/admin/{id}/edit";

        } //add to model error message for print?

        return "redirect:/admin/home";
    }

    @GetMapping(value = "/admin/create")
    public String getCreateEmployee(Model model){
        model.addAttribute(EMPLOYEE_ATTR, new EmployeeModel());
        return "pages/createEmployee";
    }

    @PostMapping(value = "/admin/create")
    public String doCreateEmployee(@ModelAttribute(EMPLOYEE_ATTR) EmployeeModel employeeModel
                                , Model model){

        try{

            employeeService.createEmployee(employeeModel);

        } catch (NullPointerException | CyclicChildException ex){

            //add to model error message for print? Doesn't show
            System.out.println(ex.getMessage());
            model.addAttribute(ERR_MSG,ex.getMessage());
            return "pages/createEmployee";
        }
        return "redirect:/admin/home";
    }


    @PostMapping(value = "/admin/{id}/delete")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteById(id);
        return "redirect:/admin/home";
    }

}
