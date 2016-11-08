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
    
    @RequestMapping("/profile/{userName}")
	public String goToProfile(@PathVariable("userName")String userName, Model model ) {
    	model.addAttribute("customer", profileService.getCustomer(userName));
		return "profile/profile";
	}

    
}
