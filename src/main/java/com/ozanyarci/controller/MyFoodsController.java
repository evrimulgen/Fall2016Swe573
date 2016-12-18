package com.ozanyarci.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.model.DateRange;
import com.ozanyarci.model.EatenItem;
import com.ozanyarci.model.Sport;
import com.ozanyarci.service.MyFoodsService;

@Controller
public class MyFoodsController {
	private final MyFoodsService myFoodsService;

    @Autowired
    public MyFoodsController(MyFoodsService myFoodsService) {
        this.myFoodsService = myFoodsService;
    }
    
    @RequestMapping("/myFoods/{userName}/{encriptedpassword}")
	public String goToMyFoodsPage(Model model, @PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedPassword) {
		
		model.addAttribute("dateRange", new DateRange());
		model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedPassword);
		return "myFoods/myFoods";
	}
    
    @RequestMapping("/myFoods/listFoodsHistory/{userName}/{encriptedpassword}")
	public String listMyFoods(Model model, @Valid @ModelAttribute("dateRange") DateRange dateRange, @PathVariable("userName")String userName, @PathVariable("encriptedpassword")String encriptedPassword) {
		
		model.addAttribute("dateRange", dateRange);
		model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedPassword);
    	List<EatenItem> foodList = myFoodsService.getEatenFoodListForDateRange(userName, dateRange);
    	List<Sport> sportList = myFoodsService.getSportListForDateRange(userName, dateRange);
    	model.addAttribute("sportList", sportList);
    	model.addAttribute("foodList",foodList);
		return "myFoods/myFoods";
	}
}
