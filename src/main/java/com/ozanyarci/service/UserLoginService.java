package com.ozanyarci.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ozanyarci.model.User;

public class UserLoginService {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public UserLoginService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
