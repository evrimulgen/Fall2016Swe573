package com.ozanyarci.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.User;

@Service
public class SignUpService {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public SignUpService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public void createCustomer(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (userName, name, birthDate, gender, height, weight, email) VALUES (?,?,?,?,?,?,?)",       		
        		customer.getUserName(),
        		customer.getName(),
        		customer.getBirthDate(),
        		customer.getGender(),
        		customer.getHeight(),
        		customer.getWeight(),
        		customer.getEmail());
    }
	
	public void insertUser(User user){
		jdbcTemplate.update("INSERT INTO login (uname, password) VALUES (?,?)",
				user.getUserName(), user.getPassword());
	}
}
