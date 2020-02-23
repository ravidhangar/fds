package com.jdbc;

public class CategoryTableobj {
	private int id;
	private String cuisine;
	/**
	 * @param id
	 * @param cuisine
	 */
	public CategoryTableobj(int id, String cuisine) {
		this.id = id;
		this.cuisine = cuisine;
	}
	public int getId() {
		return id;
	}
	public String getCuisine() {
		return cuisine;
	}
	
	
}
