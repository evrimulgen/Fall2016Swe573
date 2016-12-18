package com.ozanyarci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ozanyarci.model.CustomerHistory;
import com.ozanyarci.rowmapper.CustomerHistoryRowMapper;

@Service
public class GraphService {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GraphService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<CustomerHistory> getCustomerHistoryList(String userName) {
    	List<CustomerHistory> customerHistoryList = jdbcTemplate.query("select userName, weight, height, currentTime from customerhistory where userName = ? ", new Object[] {userName}, new CustomerHistoryRowMapper());
    	return customerHistoryList;
    }
}
