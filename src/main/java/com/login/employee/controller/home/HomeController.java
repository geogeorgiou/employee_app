package com.login.employee.controller.home;


import com.login.employee.domain.Employee;
import com.login.employee.enums.RoleType;
import com.login.employee.model.LoginResponse;
import com.login.employee.model.UserModel;
import com.login.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Controller that handles /user/home

@Controller
public class HomeController {


    //variables to assign to Model and used in ftl

    private static final String LOGGED_USER_ATTR = "loggedUser";
    private static final String LOGGED_USER_NAME = "userFirstName";
    private static final String LOGGED_USER_ROLE = "role";

    //User Service
    @Autowired
    private EmployeeService employeeService;

    //GET of /user/home

    @GetMapping(value = "/user/home")
    public String getUserProfile(Model model) {

        //Handle details of currently authenticated user

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        LoginResponse loginResponse = (LoginResponse) contextHolder.getAuthentication().getPrincipal();

        Employee loginUser = loginResponse.getLoginUser();

        //Assign variables to model in order to show data on /user/home

        UserModel userModel = employeeService.findByEmail(loginUser.getEmail());

        model.addAttribute(LOGGED_USER_ATTR, userModel);
        model.addAttribute(LOGGED_USER_NAME, loginUser.getEMP_Name());
        model.addAttribute(LOGGED_USER_ROLE, loginUser.getRole().name());

        return "pages/userHome";
    }

    //POST of /user/home
    //Handles the submitted form

    @PostMapping(value = "/user/home")
    public String postUserProfile(Model model,
                                  @ModelAttribute(LOGGED_USER_ATTR) UserModel userForm) {

        userForm.setRole(RoleType.USER);    //since we only have USER

        model.addAttribute(LOGGED_USER_ATTR, userForm);
        model.addAttribute(LOGGED_USER_NAME, userForm.getName());
        model.addAttribute(LOGGED_USER_ROLE, userForm.getRole().name());


        //updates user data
        employeeService.updateUser(userForm);
        return "redirect:/user/home";
    }



}
