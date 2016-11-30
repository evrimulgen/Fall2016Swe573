package com.ozanyarci.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.ozanyarci.model.User;
import com.ozanyarci.service.UserLoginService;

@Controller
public class LoginController {
	private final UserLoginService userLoginService;
	private static MessageDigest md;
	
    @Autowired
    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }
    
    @RequestMapping("/")
	public String toLogin(Model model) {
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("user", new User());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
		return "login/login";
	}
    
    @RequestMapping("/home")
	public String doLogin(@Valid @ModelAttribute("user")User user, Model model ) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
    	String encriptedPassword = cryptWithMD5(user.getUserName());
    	if(!userLoginService.authenticateEncriptedUserData(user.getUserName(), encriptedPassword)){
    		model.addAttribute("error","Error");
    		return "login/login";
    	}
    	model.addAttribute("error","NoError");
    	model.addAttribute("userName", user.getUserName());
    	model.addAttribute("encriptedpassword", encriptedPassword);
    	
    	
		return "welcome";
	}
    
    @RequestMapping("/home/{userName}/{encriptedpassword}")
	public String doLogin(@PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedpassword, Model model ) {
    	
    	if(!userLoginService.authenticateEncriptedUserData(userName, encriptedpassword)){
    		model.addAttribute("error","Error");
    		return "login/login";
    	}
    	model.addAttribute("error","NoError");
    	model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedpassword);
		return "welcome";
	}
    
    public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        
	    }
	        return null;
	}
    
    
    

}
