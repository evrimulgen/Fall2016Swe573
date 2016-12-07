package com.ozanyarci.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ozanyarci.model.Exercise;

public class ExerciseRowMapper implements RowMapper<Exercise> {
	public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
		Exercise exercise = new Exercise();
		exercise.setId(rs.getLong("id"));
		exercise.setExercise(rs.getString("exercise"));
		exercise.setLowWeight(rs.getDouble("130lbs"));
		exercise.setMediumWeight(rs.getDouble("155lbs"));
		exercise.setOverWeight(rs.getDouble("180lbs"));
		exercise.setObese(rs.getDouble("205lbs"));
		return exercise;
	}
}
