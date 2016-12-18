package com.ozanyarci.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.model.CustomerHistory;
import com.ozanyarci.service.GraphService;

@Controller
public class GraphController {
	private final GraphService graphService;

	@Autowired
	public GraphController(GraphService graphService) {
		this.graphService = graphService;
	}
	
	@RequestMapping("/graph/{userName}/{encriptedPassword}")
	public String toGraph(Model model, @PathVariable("userName")String userName, @PathVariable("encriptedPassword")String encriptedPassword) {
		model.addAttribute("userName", userName);
    	model.addAttribute("encriptedpassword", encriptedPassword);
    	
    	String dataAsString = "Date ";
    	dataAsString = dataAsString.concat("BMI ");
    	dataAsString = dataAsString.concat("Weight ");
    	
    	List<CustomerHistory> customerHistoryList = graphService.getCustomerHistoryList(userName);
    	for(int i = 0; i < customerHistoryList.size(); i++){
    		double bmi = customerHistoryList.get(i).getWeight() / (customerHistoryList.get(i).getHeight() * customerHistoryList.get(i).getHeight());
    		dataAsString = dataAsString.concat(customerHistoryList.get(i).getDate().toString()) + " ";
    		dataAsString = dataAsString.concat(String.valueOf(round(bmi, 2)))+ " ";
    		dataAsString = dataAsString.concat(String.valueOf(customerHistoryList.get(i).getWeight())) + " ";
    	}
    	model.addAttribute("dataAsString", dataAsString);
    	
    	
		return "graph/graph";
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
