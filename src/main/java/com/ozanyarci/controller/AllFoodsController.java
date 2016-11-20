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

@Controller
public class AllFoodsController {

	@RequestMapping("/foodsearch")
	public String openFoodSearchPage(Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		Food searchedFood = new Food();
		model.addAttribute("food", searchedFood);
		return "foodSearch/foodSearch";

	}

	@RequestMapping("/dofoodsearch")
	public String listFoods(@Valid @ModelAttribute("food") Food food, Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		model.addAttribute("food", food);
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

	@RequestMapping("/dofoodsearch/{ndbno}")
	public String foodDetails(@PathVariable("ndbno") String ndbno,Model model)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {
		List<Nutrient> nutrientList = getNutrientList(ndbno);
		NewEatenItem newEatenItem = new NewEatenItem();
		model.addAttribute("newEatenItem", newEatenItem	);
		model.addAttribute("nutrientList", nutrientList	);
		model.addAttribute("foodName", getCurrentFood(ndbno).getName());
		return "food/food";
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
				+ "&offset=0&api_key=DEMO_KEY";

		Document doc = db.parse(new URL(url).openStream());
		return doc;
	}

	private static Document parseNutritionXml(String ndbno)
			throws ParserConfigurationException, MalformedURLException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		String url = "http://api.nal.usda.gov/ndb/reports/?ndbno=" + ndbno + "&type=b&format=xml&api_key=DEMO_KEY";
		Document doc = db.parse(new URL(url).openStream());
		return doc;
	}
}
