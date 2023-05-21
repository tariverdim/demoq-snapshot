package com.example.demoq.controller;

import com.example.demoq.UserDetailsService.UserRegistrationService;
import com.example.demoq.model.User;
import com.example.demoq.model.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping
public class RegistrationController {

    private UserRegistrationService userRegistrationService;

    public RegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/register")
    public String showRegistration(WebRequest webRequest,
                                   Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerPersistence(@ModelAttribute("user") UserDto userDto, Model model) {

        if(userRegistrationService.registerNewUser(userDto)){
            return "login";
        }

        model.addAttribute("invalid", "invalid");

        return "register";
    }


}
