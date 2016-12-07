package com.ozanyarci.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.Exercise;
import com.ozanyarci.model.NewSport;
import com.ozanyarci.rowmapper.CustomerRowMapper;
import com.ozanyarci.rowmapper.ExerciseRowMapper;

@Service
public class SportService {
	
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public SportService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Exercise> getSportsList() {
    	List<Exercise> exerciseList = jdbcTemplate.query("select * from exercise", new Object[] {}, new ExerciseRowMapper());
    	return exerciseList;
    }
	
	public Customer getCustomer(String userName) {
    	Customer customer = jdbcTemplate.queryForObject("select userName, name, birthDate, gender, height, weight, email from customer where userName = ?", new Object[] {userName}, new CustomerRowMapper());
    	return customer;
    }
	
	public void createSport(NewSport sport, double caloriesBurnt, String userName) {
		Date now = new Date();
    	SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    	String date= simpleDateFormat.format(now);
        jdbcTemplate.update("INSERT INTO sport (exercise, caloriesBurnt, duration, date, userName) VALUES (?,?,?,?, ?)",       		
        		sport.getExercise(),
        		caloriesBurnt,
        		sport.getDuration(),
        		date,
        		userName);
    }
}
