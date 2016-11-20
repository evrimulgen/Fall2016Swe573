package com.ozanyarci.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.model.Customer;
import com.ozanyarci.service.ProfileService;

@Controller
public class ProfileController {
	private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    
    @RequestMapping("/profile/{userName}/{encriptedpassword}")
	public String goToProfile(@PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedpassword,  Model model ) {    	
    	Customer customer = profileService.getCustomer(userName);
    	model.addAttribute("customer", customer);   	
    	model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedpassword);
    	model.addAttribute("bmi",customer.getWeight()/customer.getHeight()/customer.getHeight());
		return "profile/profile";
	}
    
    @RequestMapping("/profile/updateprofile/{userName}/{encriptedpassword}")
	public String goToProfile(@Valid @ModelAttribute("customer")Customer customer, @PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedpassword,  Model model ) {    	
    	profileService.createCustomerHistory(customer);
    	profileService.updateCustomer(customer);
    	model.addAttribute("customer", customer);  	
    	model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedpassword);
    	model.addAttribute("bmi",customer.getWeight()/customer.getHeight()/customer.getHeight());
		return "profile/profile";
	}
    
   

    
}
