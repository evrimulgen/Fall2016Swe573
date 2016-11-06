package com.ozanyarci.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ozanyarci.service.UserLoginService;
import com.ozanyarci.model.User;;

public class LoginController {
	private final UserLoginService userLoginService;

    @Autowired
    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }
    
    @RequestMapping("/login")
	public String toLogin(Model model, @ModelAttribute("user")User user) {
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("user", new User());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
		model.addAttribute("message", "Ozan");
		return "login/home";
	}

}
