package com.tyss;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverMain {
	public static void main(String[] args) {
		DriverTest t=new DriverTest();
		try {
			DriverManager.registerDriver(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
