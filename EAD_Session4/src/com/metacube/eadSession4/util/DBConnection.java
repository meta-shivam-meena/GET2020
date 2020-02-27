package com.metacube.eadSession4.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection connection;
	
	public static Connection getConnection() {
		if (connection == null) {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/eadSession4";
			String user = "root";
			String password = "shivam";
			
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}