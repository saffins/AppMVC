package com.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	private static final String uname = "root";
	private static final String pass = "root";
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/employees";
	private static final  String driver = "com.mysql.jdbc.Driver";
	private static Connection con;
	
	
	public static Connection getDbConnection() {
		
		if(con!=null) {
			
			return con;
		}
		
		try {
 
			System.out.println("connecting to the db"); 
			Class.forName(driver);
			 con = DriverManager.getConnection(jdbcURL, uname, pass);

		System.out.println("connected successfully");

			//con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return con;
	}
	
	
}
