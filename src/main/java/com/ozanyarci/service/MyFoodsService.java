package com.ozanyarci.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.DateRange;
import com.ozanyarci.model.EatenItem;
import com.ozanyarci.model.Sport;
import com.ozanyarci.rowmapper.EatenItemRowMapper;
import com.ozanyarci.rowmapper.SportRowMapper;

@Service
public class MyFoodsService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MyFoodsService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<EatenItem> getEatenFoodListForDateRange(String userName, DateRange dateRange) {
		Date startDate = dateRange.getStartDate();
		Date endDate = dateRange.getEndDate();
    	List<EatenItem> eatenItem = jdbcTemplate.query("select foodName, amount, meal, amountType, ndbno, userName, foodEatenDate from food where userName = ? and foodEatenDate >= ? and  foodEatenDate <= ?", new Object[] {userName, startDate, endDate}, new EatenItemRowMapper());
    	return eatenItem;
    }
	
	public List<Sport> getSportListForDateRange(String userName, DateRange dateRange) {
		Date startDate = dateRange.getStartDate();
		Date endDate = dateRange.getEndDate();
    	List<Sport> sportList = jdbcTemplate.query("select exercise, caloriesBurnt, duration, date, userName from sport where userName = ? and date >= ? and date <= ? ", new Object[] {userName, startDate, endDate}, new SportRowMapper());
    	return sportList;
    }
}
