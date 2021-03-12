package com.hcl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.model.Employee;

public class EmployeeDao {

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
	

	public boolean validate(Employee employee) {
		boolean status = false;
		try {
			Connection connection = getConnection();
			
			String sql = "select * from employee where username = ? and password = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
		
		
	}
}
