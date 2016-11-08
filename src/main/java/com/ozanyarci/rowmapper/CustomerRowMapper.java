package com.ozanyarci.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ozanyarci.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>
{
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setUserName(rs.getString("userName"));
		customer.setName(rs.getString("name"));
		customer.setBirthDate(rs.getDate("birthDate"));
		customer.setGender(rs.getString("gender"));
		customer.setHeight(rs.getDouble("height"));
		customer.setWeight(rs.getDouble("weight"));
		customer.setEmail(rs.getString("email"));
		return customer;
	}

}
