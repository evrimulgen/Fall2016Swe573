package com.ozanyarci.controller;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.User;
import com.ozanyarci.service.SignUpService;
import com.ozanyarci.service.UserLoginService;

@Controller
public class SignUpController {
	private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }
    
    @RequestMapping(value = "/signup")
	public String goToSignUp(Model model ) {
    	model.addAttribute("customer", new Customer());
    	model.addAttribute("defaultDate", new SimpleDateFormat("01/01/2000"));
		return "signup/signup";
	}
    
    @RequestMapping(value = "/login")
	public String signUp(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult, Model model ) {
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("error","Error");
			return "signup/signup";
    	}
    	model.addAttribute("customer",customer);
    	User user = new User();
    	user.setUserName(customer.getUserName());
    	user.setPassword(customer.getPassword());
    	model.addAttribute("user",user);
    	signUpService.insertUser(user);
    	signUpService.createCustomer(customer);
    	signUpService.createCustomerHistory(customer);
		return "login/login";
	}
}
