package com.ozanyarci.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.ozanyarci.model.EatenItem;
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
    	String encriptedPassword = cryptWithMD5(user.getPassword());
		return login(model, user.getUserName(),encriptedPassword);
	}
    
    @RequestMapping("/home/{userName}/{encriptedPassword}")
	public String doLogin(@PathVariable("userName")String userName, @PathVariable("encriptedPassword")String encriptedPassword, Model model ) {
    	
		return login(model, userName, encriptedPassword);
	}
    
    private String login(Model model, String userName, String encriptedPassword){
    	
    	if(!userLoginService.authenticateEncriptedUserData(userName, encriptedPassword)){
    		model.addAttribute("error","Error");
    		return "login/login";
    	}
    	model.addAttribute("error","NoError");
    	model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedPassword);
    	List<EatenItem> eatenItemList = userLoginService.getEatenFoodList(userName);
    	List<EatenItem> breakfastList = new ArrayList<EatenItem>();
    	List<EatenItem> lunchList = new ArrayList<EatenItem>();
    	List<EatenItem> dinnerList = new ArrayList<EatenItem>();
    	List<EatenItem> otherList = new ArrayList<EatenItem>();
    	
    	for(int i= 0; i < eatenItemList.size(); i++){
    		String meal = eatenItemList.get(i).getMeal();
    		if(new String(meal).equals("Breakfast")){
    			breakfastList.add(eatenItemList.get(i));
    		}
    		else if(new String(meal).equals("Lunch")){
    			lunchList.add(eatenItemList.get(i));
    		}
    		else if(new String(meal).equals("Dinner")){
    			dinnerList.add(eatenItemList.get(i));
    		}
    		else{
    			otherList.add(eatenItemList.get(i));
    		}
    	}
    	
    	model.addAttribute("breakfastList", breakfastList);
    	model.addAttribute("lunchList", lunchList);
    	model.addAttribute("dinnerList", dinnerList);
    	model.addAttribute("otherList", otherList);
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
