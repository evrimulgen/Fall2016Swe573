package com.ozanyarci.model;

public class Exercise {
	private long id;
	private String exercise;
    private double lowWeight;
    private double mediumWeight;
    private double overWeight;
    private double obese;
    
    public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
    
    public String getExercise() {
		return exercise;
	}
 
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
     
    public double getLowWeight() {
		return lowWeight;
	}
 
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	
	public double getMediumWeight() {
		return mediumWeight;
	}
 
	public void setMediumWeight(double mediumWeight) {
		this.mediumWeight = mediumWeight;
	}
	
	public double getOverWeight() {
		return overWeight;
	}
 
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	
	public double getObese() {
		return obese;
	}
 
	public void setObese(double obese) {
		this.obese = obese;
	}
}
