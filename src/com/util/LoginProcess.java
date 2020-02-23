package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginProcess {
	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
	public boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		Matcher matcher = pattern.matcher(password);
		return matcher.find();
	}
	
}
