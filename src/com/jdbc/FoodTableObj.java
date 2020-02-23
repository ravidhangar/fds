package com.jdbc;

public class FoodTableObj {
	private int id=0;
	private String foodname=null;
	private int categoryid=0;
	private int rate=0;
	private int stock=0;
	private String description=null;
	
	
	/**
	 * 
	 */
	public FoodTableObj() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param foodname
	 * @param categoryid
	 * @param rate
	 * @param stock
	 * @param description
	 */
	public FoodTableObj(int id,String foodname, int categoryid, int rate, int stock, String description) {
		this.id=id;
		this.foodname = foodname;
		this.categoryid = categoryid;
		this.rate = rate;
		this.stock = stock;
		this.description = description;
	}
	public String getFoodname() {
		return foodname;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public int getRate() {
		return rate;
	}
	public int getStock() {
		return stock;
	}
	public String getDescription() {
		return description;
	}
	public int getId() {
		return id;
	}
}
