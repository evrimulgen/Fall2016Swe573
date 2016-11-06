package com.ozanyarci.controller;

import com.ozanyarci.model.User;
import com.ozanyarci.service.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
/**
 * @author <a href="mailto:ozan.yarci@veripark.com">Ozan Yarcı</a>
 */
@Controller
public class HomeController {
    private final DbService dbService;

    @Autowired
    public HomeController(DbService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping("/")
    public String homePage(Model model) {
        dbService.saveRandomRecord();
        model.addAttribute("message", "Ozan");
        return "index";
    }
    
    @RequestMapping("/login")
	public String toLogin(Model model) {
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("user", new User());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
		model.addAttribute("message", "Ozan");
		return "login/login";
	}
    
    @RequestMapping("/doLogin")
	public String doLogin(@Valid @ModelAttribute("user")User user, Model model ) {
    	if(!dbService.authenticateUser(user)){
    		model.addAttribute("error","Error");
    		return "login/login";
    	}
    	model.addAttribute("error","NoError");
    	model.addAttribute("user", user);
		return "welcome";
	}
}