package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepOfJdbc {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/";
		String user = "postgres";
		String password = "root";
		try {
			Class c=Class.forName(driver);
			System.out.println(c);
//			Connection con = DriverManager.getConnection(url, user, password);
//			Statement stm = con.createStatement();
//			System.out.println(con);

			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
