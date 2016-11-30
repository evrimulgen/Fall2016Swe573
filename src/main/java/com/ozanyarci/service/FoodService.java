package com.ozanyarci.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.NewEatenItem;

@Service
public class FoodService {
	private final JdbcTemplate jdbcTemplate;
    private static final int maxfoodNameLength = 100;
	@Autowired
	public FoodService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveEatenItem(String userName, String ndbno, NewEatenItem newEatenItem) {
    	Date now = new Date();
    	SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String currentTime = simpleDateFormat.format(now);
    	String foodName = newEatenItem.getFoodName().substring(0, Math.min(newEatenItem.getFoodName().length(), maxfoodNameLength));
        jdbcTemplate.update("INSERT INTO food (userName, ndbno, foodName, amount, foodEatenDate, meal, amountType) VALUES (?,?, ?,?,?,?,?)",       		
        		userName,
        		ndbno,
        		foodName,
        		newEatenItem.getAmount(),
        		currentTime,
        		newEatenItem.getMeal(),
        		newEatenItem.getAmountType());
    }
}
