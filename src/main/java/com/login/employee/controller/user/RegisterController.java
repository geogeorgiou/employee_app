package com.login.employee.controller.user;


import com.login.employee.enums.RoleType;
import com.login.employee.exception.DuplicateEmailException;
import com.login.employee.model.LoginUserModel;
import com.login.employee.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


//Controller that handles /register

//since this functionality is not dependent on the user but more
//on DB data it will become a separate controller instead of becoming
//part of UserController for abstraction reasons

@Controller
public class RegisterController {


    private static final String LOGGED_USER_ATTR = "loggedUser";
    private static final String LOGGED_USER_NAME = "userFirstName";
    private static final String LOGGED_USER_ROLE = "role";
    private static final String DUPLICATE_MAIL_MSG = "duplicateMail";

    private static final String USER_ROLETYPES = "userRoles";

    //User Service

    @Autowired
    private LoginUserService logService;

    //GET /register

    @GetMapping({"/register"})
    public String getRegister(Model model){

        //assign UserModel attribute to model to use it later
        model.addAttribute(LOGGED_USER_ATTR, new LoginUserModel());
        model.addAttribute(USER_ROLETYPES, RoleType.values());

        return "pages/register";
    }

    //POST /register
    @PostMapping({"/register"})
    public String postRegister(Model model,
                                @ModelAttribute(LOGGED_USER_ATTR) LoginUserModel userForm){

        //try-catch block for Duplicate Mail check
        //when duplicate mail is inserted an error message will be show on /register

        try {

            model.addAttribute(LOGGED_USER_ATTR, userForm);
            model.addAttribute(LOGGED_USER_NAME, userForm.getLogName());
            model.addAttribute(LOGGED_USER_ROLE, userForm.getRole().name());

            //Creates user
            logService.createUser(userForm);

        }catch (DuplicateEmailException dee){

            //if mail found to be duplicate assign variable with error message to model
            model.addAttribute(DUPLICATE_MAIL_MSG, dee.getMessage());

            //redirect to /register when duplicate mail inserted!
            return "pages/register";
        }


        return "redirect:/login";
    }
}
