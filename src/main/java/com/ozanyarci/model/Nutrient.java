package com.ozanyarci.model;

import java.util.List;

public class Nutrient {
	private List<Measure> measureList = null;
	private String name;
	private String unit;   
    private String value;
	
	public List<Measure> getMeasureList() {
        return measureList;
    }
 
    public void setMeasureList(List<Measure> measureList) {
        this.measureList = measureList;
    }
    
    public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUnit() {
		return unit;
	}
 
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}
}
