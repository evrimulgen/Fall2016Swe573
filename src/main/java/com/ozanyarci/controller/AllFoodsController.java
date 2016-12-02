package com.ozanyarci.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ozanyarci.model.AllFoods;
import com.ozanyarci.model.Food;
import com.ozanyarci.model.Measure;
import com.ozanyarci.model.NewEatenItem;
import com.ozanyarci.model.Nutrient;
import com.ozanyarci.service.FoodService;

@Controller
public class AllFoodsController {

	private final FoodService foodService;
	
    @Autowired
    public AllFoodsController(FoodService foodService) {
        this.foodService = foodService;
    }
    
    @RequestMapping("/home/{userName}/{encriptedpassword}/{ndbno}/{amount}/{amountType}/{meal}")
	public String foodDetail(@PathVariable("userName") String userName,
			@PathVariable("encriptedpassword") String encriptedpassword, 
			@PathVariable("ndbno") String ndbno,
			@PathVariable("amount") String amount,
			@PathVariable("amountType") String amountType,
			@PathVariable("meal") String meal,
			Model model) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
    	List<Nutrient> nutrientList = getNutrientList(ndbno);
    	List<Nutrient> selectedNutrientList = setSelectedNutrientList(nutrientList, amount, amountType);

		model.addAttribute("nutrientList", selectedNutrientList);
		model.addAttribute("userName", userName);
		model.addAttribute("encriptedpassword", encriptedpassword);
		model.addAttribute("amount", amount);
		model.addAttribute("amountType", amountType);
		model.addAttribute("meal", meal);
		model.addAttribute("foodName", getCurrentFood(ndbno).getName());
		return "food/foodDetail";

	}
    
    private List<Nutrient> setSelectedNutrientList(List<Nutrient> nutrientList, String amount, String amountType){
    	List<Nutrient> selectedNutrientList = new ArrayList<Nutrient>();
    	double amountInt = Double.parseDouble(amount);
    	for(int i = 0; i < nutrientList.size(); i++){
    		Nutrient nutrient = new Nutrient();
    		nutrient.setName(nutrientList.get(i).getName());
    		nutrient.setUnit(nutrientList.get(i).getUnit());
    		if(new String(amountType).equals("gr")){
    			nutrient.setValue(String.valueOf(Double.parseDouble(nutrientList.get(i).getValue()) * amountInt / 100));
    		}
    		else{
    			List<Measure> measureList = nutrientList.get(i).getMeasureList();
    			for(int j = 0; j < nutrientList.get(i).getMeasureList().size(); j++){
    				String measureListLabel = nutrientList.get(i).getMeasureList().get(j).getLabel();
    				if(new String(nutrientList.get(i).getMeasureList().get(j).getLabel()).equals(amountType))
    				{
    					String measureListValue = nutrientList.get(i).getMeasureList().get(j).getValue();
    					nutrient.setValue(String.valueOf(Double.parseDouble(nutrientList.get(i).getMeasureList().get(j).getValue()) * amountInt));
    					break;
    				}
    			}
    			
    		}
    		selectedNutrientList.add(nutrient);
    	}
    	return selectedNutrientList;
    }
    
	@RequestMapping("/home/{userName}/{encriptedpassword}/foodsearch")
	public String openFoodSearchPage(@PathVariable("userName") String userName,
			@PathVariable("encriptedpassword") String encriptedpassword, Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		Food searchedFood = new Food();
		model.addAttribute("food", searchedFood);
		model.addAttribute("userName", userName);
		model.addAttribute("encriptedpassword", encriptedpassword);
		return "foodSearch/foodSearch";

	}

	@RequestMapping("/home/{userName}/{encriptedpassword}/dofoodsearch")
	public String listFoods(@Valid @ModelAttribute("food") Food food, @PathVariable("userName") String userName,
			@PathVariable("encriptedpassword") String encriptedpassword, Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		model.addAttribute("food", food);
		model.addAttribute("userName", userName);
		model.addAttribute("encriptedpassword", encriptedpassword);
		try {
			AllFoods allfoods = unMarshalXml(food.getName());

			System.out.println();
			model.addAttribute("allfoods", allfoods.getFoods());
			return "foodSearch/foodSearch";
		} catch (JAXBException ex) {
			model.addAttribute("unMarshalXml", ex.getMessage());
			return "foodSearch/foodSearch";
		}
	}

	@RequestMapping("/home/{userName}/{encriptedpassword}/dofoodsearch/{ndbno}")
	public String foodDetails2(@PathVariable("userName") String userName,
			@PathVariable("encriptedpassword") String encriptedpassword, @PathVariable("ndbno") String ndbno,
			Model model) throws ParserConfigurationException, MalformedURLException, SAXException, IOException {
		List<Nutrient> nutrientList = getNutrientList(ndbno);
		List<Measure> measureList = nutrientList.get(0).getMeasureList();
		
		model.addAttribute("labelList", getLabelList(measureList));
		NewEatenItem newEatenItem = new NewEatenItem();
		model.addAttribute("newEatenItem", newEatenItem);
		model.addAttribute("measureList", measureList);
		model.addAttribute("nutrientList", nutrientList);
		model.addAttribute("userName", userName);
		model.addAttribute("foodName", getCurrentFood(ndbno).getName());
		model.addAttribute("encriptedpassword", encriptedpassword);
		createMealList(model);
		return "food/food";
	}
	
	@RequestMapping("/home/{userName}/{encriptedpassword}/dofoodsearch/{ndbno}/saveEatenItem")
	public String saveFood(@Valid @ModelAttribute("newEatenItem") NewEatenItem newEatenItem,@PathVariable("userName") String userName, @PathVariable("encriptedpassword") String encriptedpassword, @PathVariable("ndbno") String ndbno, Model model){
		foodService.saveEatenItem(userName, ndbno, newEatenItem);
		model.addAttribute("userName",userName);
		model.addAttribute("encriptedpassword",encriptedpassword);
		return "food/foodSuccess";
	}
	
	private List<String> getLabelList(List<Measure> measureList){
		List<String> labelList = new ArrayList<String>();
		labelList.add("gr");
		for (int i = 0; i < measureList.size(); i++) {
			String label = measureList.get(i).getLabel();
			labelList.add(label);
		}
		return labelList;
	}

	private void createMealList(Model model) {
		List<String> mealList = new ArrayList<String>();
		mealList.add("Breakfast");
		mealList.add("Lunch");
		mealList.add("Dinner");
		mealList.add("Other");
		model.addAttribute("mealList", mealList);
	}

	private Food getCurrentFood(String ndbno)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {
		Document document = parseNutritionXml(ndbno);
		document.getDocumentElement().normalize();
		Food food = new Food();
		NodeList foodList = document.getElementsByTagName("food");
		for (int i = 0; i < foodList.getLength(); i++) {
			Node node = foodList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				food.setName(eElement.getAttribute("name"));
			}

		}
		return food;
	}

	private List<Nutrient> getNutrientList(String ndbno)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {
		Document document = parseNutritionXml(ndbno);
		document.getDocumentElement().normalize();
		List<Nutrient> nutrientList = new ArrayList<Nutrient>();
		NodeList nList = document.getElementsByTagName("nutrient");

		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				Nutrient nutrient = new Nutrient();
				nutrient.setName(eElement.getAttribute("name"));
				nutrient.setUnit(eElement.getAttribute("unit"));
				nutrient.setValue(eElement.getAttribute("value"));

				NodeList measureList = eElement.getElementsByTagName("measure");
				List<Measure> nutrientMeasureList = new ArrayList<Measure>();

				for (int temp = 0; temp < measureList.getLength(); temp++) {
					Node measureListNode = measureList.item(temp);
					Measure measure = new Measure();
					if (measureListNode.getNodeType() == Node.ELEMENT_NODE) {
						Element measureListNodeElement = (Element) measureListNode;
						measure.setLabel(measureListNodeElement.getAttribute("label"));
						measure.setEqv(measureListNodeElement.getAttribute("eqv"));
						measure.setQty(measureListNodeElement.getAttribute("qty"));
						measure.setValue(measureListNodeElement.getAttribute("value"));
						nutrientMeasureList.add(measure);
					}
				}
				nutrient.setMeasureList(nutrientMeasureList);
				nutrientList.add(nutrient);
			}
		}
		return nutrientList;
	}

	private static AllFoods unMarshalXml(String searchedFoodName)
			throws JAXBException, MalformedURLException, ParserConfigurationException, SAXException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(AllFoods.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AllFoods allfoods = (AllFoods) jaxbUnmarshaller.unmarshal(parseXml(searchedFoodName));
		return allfoods;
	}

	private static Document parseXml(String searchedFoodName)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		String encodedsearchedFoodName = null;
		try {
			encodedsearchedFoodName = URLEncoder.encode(searchedFoodName, "UTF-8");
		} catch (UnsupportedEncodingException ignored) {
			// Can be safely ignored because UTF-8 is always supported
		}
		String url = "http://api.nal.usda.gov/ndb/search/?format=xml&q=" + encodedsearchedFoodName
				+ "&offset=0&api_key=JUiX3d2YKXGRhug2i9MLKMCcJOJLFKyXxrZg85Tt";

		Document doc = db.parse(new URL(url).openStream());
		return doc;
	}

	private static Document parseNutritionXml(String ndbno)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		String url = "http://api.nal.usda.gov/ndb/reports/?ndbno=" + ndbno
				+ "&type=b&format=xml&api_key=JUiX3d2YKXGRhug2i9MLKMCcJOJLFKyXxrZg85Tt";
		Document doc = db.parse(new URL(url).openStream());
		return doc;
	}
}
