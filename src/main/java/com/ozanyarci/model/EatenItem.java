package com.ozanyarci.model;

import java.sql.Date;

public class EatenItem {
	private String foodName;
	private String amount;
	private String amountType;
	private String meal;
	private Date foodEatenDate;
	private String userName;
	private String ndbno;
	
	public String getFoodName() {
		return foodName;
	}
 
	public void setFoodName(String foodName) {
		this.foodName = foodName;
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
	
	public Date getFoodEatenDate() {
		return foodEatenDate;
	}
 
	public void setFoodEatenDate(Date foodEatenDate) {
		this.foodEatenDate = foodEatenDate;
	}
	
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getNdbno() {
		return ndbno;
	}
 
	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}
}
