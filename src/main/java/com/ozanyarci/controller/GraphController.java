package com.ozanyarci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "graph/graph";
	}
}
