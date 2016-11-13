package com.ozanyarci.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.Customer;
import com.ozanyarci.rowmapper.CustomerRowMapper;

@Service
public class ProfileService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6017573630618116471L;
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public ProfileService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer getCustomer(String userName) {
    	Customer customer = jdbcTemplate.queryForObject("select userName, name, birthDate, gender, height, weight, email from customer where userName = ?", new Object[] {userName}, new CustomerRowMapper());
    	return customer;
    }
    
    public void updateCustomer(Customer customer){
    	jdbcTemplate.update("update customer set birthDate = ?, gender = ?, height = ?, weight = ? where userName = ?", 
    			customer.getBirthDate(),
    			customer.getGender(),
    			customer.getHeight(),
    			customer.getWeight(),
    			customer.getUserName());
    }
    
    public void createCustomerHistory(Customer customer) {
    	Date now = new Date();
    	SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String currentTime = simpleDateFormat.format(now);
        jdbcTemplate.update("INSERT INTO customerhistory (userName, birthDate, gender, height, weight, currentTime) VALUES (?,?,?,?,?, ?)",       		
        		customer.getUserName(),
        		customer.getBirthDate(),
        		customer.getGender(),
        		customer.getHeight(),
        		customer.getWeight(),
        		currentTime);
    }
}
