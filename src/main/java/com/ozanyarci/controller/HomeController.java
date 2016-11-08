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

    @RequestMapping("/index")
    public String homePage(Model model) {
        dbService.saveRandomRecord();
        model.addAttribute("message", "Ozan");
        return "index";
    }
    
    
}