package com.ozanyarci.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.CustomerHistory;

public class CustomerHistoryRowMapper implements RowMapper<CustomerHistory>{
	public CustomerHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerHistory customer = new CustomerHistory();
		customer.setUserName(rs.getString("userName"));
		customer.setDate(rs.getDate("currentTime"));
		customer.setHeight(rs.getDouble("height"));
		customer.setWeight(rs.getDouble("weight"));
		return customer;
	}
}
