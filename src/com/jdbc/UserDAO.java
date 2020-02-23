package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.User;

public class UserDAO {
	public boolean checkUser(User user) {
		Connection con=new DatabaseConnect().getConnection();
		boolean bool=false;
		String sql="SELECT * FROM customer WHERE email=?";
		try {
			
			PreparedStatement pStatement=con.prepareStatement(sql);
			pStatement.setString(1, user.getEmail());
			
			ResultSet rs=pStatement.executeQuery();
			
			while (rs.next()) {
				if(rs.getString("password").equals(user.getPassword())) {
					bool=true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	public boolean createCustomer(User u) {
		boolean bool=false;
		DatabaseConnect dbConnect=new DatabaseConnect();
		Connection con=dbConnect.getConnection();
		
		String sql="INSERT INTO customer(email,password) values(?,?)";
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, u.getEmail());
			pstat.setString(2, u.getPassword());
			
			bool=pstat.execute();
			
			pstat.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}
