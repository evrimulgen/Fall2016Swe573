package com.ozanyarci.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.EatenItem;
import com.ozanyarci.model.Sport;
import com.ozanyarci.rowmapper.EatenItemRowMapper;
import com.ozanyarci.rowmapper.SportRowMapper;

@Service
public class UserLoginService {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserLoginService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	
	public boolean authenticateEncriptedUserData(String userName, String encriptedPassword) {
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForObject("select count(*) from login " + " where uname = ? and password = ?",
				Integer.class, userName, encriptedPassword);
		if (rowcount == 1) {
			userExists = true;
		}
		return userExists;
	}
	
	public List<EatenItem> getEatenFoodList(String userName) {
		Date now = new Date();
    	SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	String currentTime = simpleDateFormat.format(now);
    	List<EatenItem> eatenItemList = jdbcTemplate.query("select foodName, amount, meal, amountType, ndbno, userName, foodEatenDate from food where userName = ? and foodEatenDate = ?", new Object[] {userName, currentTime}, new EatenItemRowMapper());
    	return eatenItemList;
    }
	
	public List<Sport> getSportList(String userName) {
		Date now = new Date();
    	SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	String currentTime = simpleDateFormat.format(now);
    	List<Sport> sportList = jdbcTemplate.query("select exercise, caloriesBurnt, duration, date, userName from sport where userName = ? and date = ?", new Object[] {userName, currentTime}, new SportRowMapper());
    	return sportList;
    }
}
