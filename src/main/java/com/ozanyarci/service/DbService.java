package com.ozanyarci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.User;

import java.util.UUID;

/**
 * @author <a href="mailto:ozan.yarci@veripark.com">Ozan Yarcı</a>
 */
@Service
public class DbService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DbService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveRandomRecord() {
        jdbcTemplate.update("INSERT INTO `test-table` (text) VALUES (?)",
                UUID.randomUUID().toString());
    }
    
    @SuppressWarnings("deprecation")
	public boolean authenticateUser(User user){
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForObject("select count(*) from login " +
				" where uname = ? and password = ?", Integer.class,
				user.getUserId(),user.getPassword());
		if(rowcount==1){
			userExists = true;
		}
		return userExists;
	}
    
   
}
