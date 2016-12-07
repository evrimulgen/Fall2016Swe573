package com.ozanyarci.model;

import java.sql.Date;

public class Sport {
	private String exercise;
	private long duration;
	private double caloriesBurnt;
	private Date date;
	private String userName;
	
	public String getExercise() {
		return exercise;
	}
 
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	
	public long getDuration() {
		return duration;
	}
 
	public void setCaloriesBurnt(double caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}
	
	public double getCaloriesBurnt() {
		return caloriesBurnt;
	}
 
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
