package com.ozanyarci.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.Exercise;
import com.ozanyarci.model.NewSport;
import com.ozanyarci.service.SportService;

@Controller
public class SportController {

	private final SportService sportService;
	private final double lbs = 2.205;
	private final double lowWeight = 130;
	private final double normalWeight = 155;
	private final double overWeight = 180;
	private final double obese = 205;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }
	@RequestMapping("/home/{userName}/{encriptedPassword}/sportsList")
	public String listSports(@PathVariable("userName")String userName, @PathVariable("encriptedPassword")String encriptedPassword, Model model ) {
		List<Exercise> exerciseList = sportService.getSportsList();
		model.addAttribute("encriptedpassword",encriptedPassword);
		model.addAttribute("userName",userName);
		model.addAttribute("exerciseList",exerciseList);
		return "sports/sports";
	}
	
	@RequestMapping("/home/{userName}/{encriptedPassword}/addSport/{exerciseId}")
	public String addSport(@PathVariable("userName") String userName,
			@PathVariable("encriptedPassword") String encriptedPassword,
			@PathVariable("exerciseId")long exerciseId, Model model ) {
		List<Exercise> exerciseList = sportService.getSportsList();
		for(int i = 0; i < exerciseList.size(); i++){
			if(exerciseList.get(i).getId() == exerciseId){
				model.addAttribute("exerciseName", exerciseList.get(i).getExercise());
			}
		}
		model.addAttribute("exerciseList",exerciseList);
		model.addAttribute("encriptedpassword",encriptedPassword);
		model.addAttribute("userName",userName);
		NewSport sport = new NewSport();
		model.addAttribute("sport",sport);
		return "sports/addSport";
	}
	
	@RequestMapping("/home/{userName}/{encriptedPassword}/addSport/{exerciseId}/saveSport")
	public String saveSport(@Valid @ModelAttribute("sport")NewSport sport, @PathVariable("userName") String userName,
			@PathVariable("encriptedPassword") String encriptedPassword,
			@PathVariable("exerciseId")long exerciseId, Model model ) {
		List<Exercise> exerciseList = sportService.getSportsList();
		Exercise exercise = new Exercise();
		String selectedWeight = null;
		for(int i = 0; i < exerciseList.size(); i++){
			if(exerciseList.get(i).getId() == exerciseId){
				exercise.setExercise(exerciseList.get(i).getExercise());
				exercise.setLowWeight(exerciseList.get(i).getLowWeight());
				exercise.setMediumWeight(exerciseList.get(i).getMediumWeight());
				exercise.setOverWeight(exerciseList.get(i).getOverWeight());
				exercise.setObese(exerciseList.get(i).getObese());
			}
		}
		Customer customer = sportService.getCustomer(userName);
		double weight = customer.getWeight()* lbs;
		double difference = Math.abs(weight - lowWeight);
		selectedWeight = "lowWeight";
		if(difference > Math.abs(weight - normalWeight)){
			difference = Math.abs(weight - normalWeight);
			selectedWeight = "normalWeight";			
		}
		if(difference > Math.abs(weight - overWeight)){
			difference = Math.abs(weight - overWeight);
			selectedWeight = "overWeight";
		}
		if(difference > Math.abs(weight - obese)){
			difference = Math.abs(weight - obese);
			selectedWeight = "obese";
		}
		double caloriesBurnt = 0;
		if(new String(selectedWeight).equals("lowWeight")){
			caloriesBurnt = exercise.getLowWeight() * sport.getDuration() / 60;
		}
		
		if(new String(selectedWeight).equals("normalWeight")){
			caloriesBurnt = exercise.getMediumWeight() * sport.getDuration() / 60;
		}
		
		if(new String(selectedWeight).equals("overWeight")){
			caloriesBurnt = exercise.getOverWeight() * sport.getDuration() / 60;
		}
		
		if(new String(selectedWeight).equals("obese")){
			caloriesBurnt = exercise.getObese() * sport.getDuration() / 60;
		}
		sportService.createSport(sport,caloriesBurnt, userName);
		model.addAttribute("exerciseList",exerciseList);
		model.addAttribute("encriptedpassword",encriptedPassword);
		model.addAttribute("userName",userName);
		return "sports/saveSportSuccess";
	}
	
}
