package com.ozanyarci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.service.ProfileService;

@Controller
public class ProfileController {
	private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    
    @RequestMapping("/profile/{userName}/{encriptedpassword}")
	public String goToProfile(@PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedpassword, Model model ) {
    	model.addAttribute("customer", profileService.getCustomer(userName));
    	model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedpassword);
		return "profile/profile";
	}

    
}
