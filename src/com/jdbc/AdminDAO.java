package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.User;

public class AdminDAO {
	public boolean checkAdmin(User user) {
		DatabaseConnect databaseConnect = new DatabaseConnect();
		Connection con = databaseConnect.getConnection();
		boolean bool = false;
		String sql = "SELECT * FROM admin WHERE email=?";
		try {
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, user.getEmail());

			ResultSet rs = pStatement.executeQuery();

			while (rs.next()) {

				if (rs.getString("password").equals(user.getPassword())) {
					bool = true;
				}

			}
			pStatement.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public boolean createAdmin(User u) {
		boolean bool=false;
		DatabaseConnect dbConnect=new DatabaseConnect();
		Connection con=dbConnect.getConnection();
		
		String sql="INSERT INTO admin(email,password) values(?,?)";
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

	public boolean insertCategory(String category) {
		boolean result = false;
		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();

		String sql = "INSERT INTO category(cuisine) values(?)";

		try {
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, category);

			result = pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<CategoryTableobj> fetchDataFromCategoryTable() {
		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();
		ArrayList<CategoryTableobj> categories = new ArrayList<CategoryTableobj>(0);

		String sql = "SELECT * FROM category";
		try {
			Statement stat = con.createStatement();

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String cuisine = rs.getString("cuisine");

				CategoryTableobj temp = new CategoryTableobj(id, cuisine);
				categories.add(temp);
			}
			stat.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	public boolean insertDataInFood(String name, int categoryid, int rate, int stock, String description) {
		boolean bool = false;
		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();
		String sql = "INSERT INTO food(name,categoryid,rate,stock,description) VALUES(?,?,?,?,?)";

		try {
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, name);
			pstat.setInt(2, categoryid);
			pstat.setInt(3, rate);
			pstat.setInt(4, stock);
			pstat.setString(5, description);

			bool = pstat.execute();

			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public ArrayList<FoodTableObj> fetchDataFromFood() {
		DatabaseConnect dbConnect = new DatabaseConnect();

		Connection con = dbConnect.getConnection();

		ArrayList<FoodTableObj> foods = new ArrayList<FoodTableObj>();

		String sql = "SELECT * FROM food";
		try {
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String foodname = rs.getString("name");
				int categoryid = rs.getInt("categoryid");
				int rate = rs.getInt("rate");
				int stock = rs.getInt("stock");
				String description = rs.getString("description");

				FoodTableObj temp = new FoodTableObj(id, foodname, categoryid, rate, stock, description);
				foods.add(temp);
			}
			statement.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foods;
	}

	public boolean deleteFood(int id) {
		boolean bool = false;

		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();

		String sql = "DELETE FROM food WHERE id=?";

		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);

			bool = pstat.execute();

			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	public FoodTableObj fectchUsingId(int id) {
		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();

		FoodTableObj foodTableObj = null;

		String sql = "SELECT * FROM food where id=?";
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int foodId = rs.getInt("id");
				String name = rs.getString("name");
				int categoryid = rs.getInt("categoryid");
				int rate = rs.getInt("rate");
				int stock = rs.getInt("stock");
				String description = rs.getString("description");
				
				foodTableObj=new FoodTableObj(foodId, name, categoryid, rate, stock, description);
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodTableObj;
	}
	
	public boolean modifyFood(FoodTableObj obj) {
		boolean bool=false;
		
		DatabaseConnect dbConnect=new DatabaseConnect();
		Connection con=dbConnect.getConnection();
		
		String sql="UPDATE food SET name=?,categoryid=?,rate=?,stock=?,description=? where id=?";
		
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, obj.getFoodname());
			pstat.setInt(2, obj.getId());
			pstat.setInt(3, obj.getRate());
			pstat.setInt(4, obj.getStock());
			pstat.setString(5, obj.getDescription());
			pstat.setInt(6, obj.getId());
			
			bool=pstat.execute();
			
			pstat.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
	public boolean deleteCategory(int id) {
		boolean bool = false;

		DatabaseConnect dbConnect = new DatabaseConnect();
		Connection con = dbConnect.getConnection();

		String sql = "DELETE FROM category WHERE id=?";

		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);

			bool = pstat.execute();

			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}
}
