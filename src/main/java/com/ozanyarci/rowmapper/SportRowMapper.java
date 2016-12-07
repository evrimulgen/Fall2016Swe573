package com.ozanyarci.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ozanyarci.model.Sport;

public class SportRowMapper implements RowMapper<Sport> {
	public Sport mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sport sport = new Sport();
		sport.setExercise(rs.getString("exercise"));
		sport.setCaloriesBurnt(rs.getDouble("caloriesBurnt"));
		sport.setDuration(rs.getLong("duration"));
		sport.setDate(rs.getDate("date"));
		sport.setUserName(rs.getString("userName"));
		return sport;
	}
}