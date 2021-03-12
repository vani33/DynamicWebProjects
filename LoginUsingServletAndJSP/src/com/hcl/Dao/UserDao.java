package com.hcl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.model.User;

public class UserDao {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hcl";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// create or insert user
	public User insertUser(User user) {
		try {
			Connection connection = getConnection();
			String sql = "Insert into User values(" + "(?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	public List<User> fetchUser() {
		List<User> users = new ArrayList<User>();
		try {
			Connection connection = getConnection();
			String sql = "select * from user where id = ? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				
				users.add(new User(id, name, email, city));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;

	}

	public User updateUser(User user) {
		try {
			Connection connection = getConnection();
			String sql = "Update User set name = ?, email =?, city = ? where id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCity());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int deleteUser(int id) {
		try {

			Connection connection = getConnection();
			String sql = "delete from users where id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}

}
