package com.ozanyarci.model;

public class NewEatenItem {
	private String foodName;
	private String when;
	private String amount;
	private String amountType;
	private String meal;
	
 
	public String getFoodName() {
		return foodName;
	}
 
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
 
	public String getWhen() {
		return when;
	}
 
	public void setWhen(String when) {
		this.when = when;
	}
	
	public String getAmountType() {
		return amountType;
	}
 
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	
	public String getAmount() {
		return amount;
	}
 
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getMeal() {
		return meal;
	}
 
	public void setMeal(String meal) {
		this.meal = meal;
	}
}
