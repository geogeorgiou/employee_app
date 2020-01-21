package com.login.webapp.controller.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Controller to handle /login

@Controller
public class LoginController {

    //GET /login

    //error parameter is used at login page to display error message
    //when credentials are invalid

    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "error", required = false)
                                    boolean error,
                        Model model) {
        model.addAttribute("hasError", error);
        return "pages/login";
    }

}
