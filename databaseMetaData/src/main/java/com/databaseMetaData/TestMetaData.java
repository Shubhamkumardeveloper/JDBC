package com.databaseMetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class TestMetaData {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/Product";
		String user="postgres";
		String password="root";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			//fetching the information about the database...
			//creating the object of metadata...
			DatabaseMetaData dmd=con.getMetaData();
			String username=dmd.getUserName();
			System.out.println(username);
			
			String driverVersion=dmd.getDriverVersion();
			System.out.println(driverVersion);
			
			String driverName=dmd.getDriverName();
			System.out.println(driverName);
			
			boolean res=dmd.supportsFullOuterJoins();
			System.out.println(res);
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
