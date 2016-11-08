package com.ozanyarci.service;

import java.io.Serializable;

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
}
