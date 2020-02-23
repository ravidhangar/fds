package com.util;

public class User {
	private String email;
	private String password;
	private String userType;
	/**
	 * @param email
	 * @param password
	 */
	public User(String email, String password,String userType) {
		this.email = email;
		this.password = password;
		this.userType=userType;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getUserType() {
		return userType;
	}
}
