package com.tyss;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class JDBC_Load {
	public static void main(String[] args) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			System.out.println("DRIVER IS LOADED");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		Driver driver=new Driver();
		try {
			DriverManager.registerDriver(driver);
			System.out.println("DRIVER IS LOADED");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
