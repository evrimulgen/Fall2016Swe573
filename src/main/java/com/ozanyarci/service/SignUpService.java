package com.ozanyarci.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.User;

@Service
public class SignUpService {

	private final JdbcTemplate jdbcTemplate;
	private static MessageDigest md;
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
		String encriptedPassword = cryptWithMD5(user.getPassword());
		jdbcTemplate.update("INSERT INTO login (uname, password) VALUES (?,?)",
				user.getUserName(), encriptedPassword);
	}
	
	public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        
	    }
	        return null;
	}
}
