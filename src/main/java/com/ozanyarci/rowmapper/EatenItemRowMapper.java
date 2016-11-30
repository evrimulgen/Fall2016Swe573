package com.ozanyarci.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ozanyarci.model.EatenItem;

public class EatenItemRowMapper implements RowMapper<EatenItem>{
	public EatenItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		EatenItem eatenItem = new EatenItem();		
		eatenItem.setUserName(rs.getString("userName"));
		eatenItem.setFoodName(rs.getString("foodName"));
		eatenItem.setAmount(rs.getString("amount"));
		eatenItem.setFoodEatenDate(rs.getDate("foodEatenDate"));
		eatenItem.setMeal(rs.getString("meal"));
		eatenItem.setAmountType(rs.getString("amountType"));		
		eatenItem.setNdbno(rs.getString("ndbno"));
		
		return eatenItem;
	}
}
