package com.resultsetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestResultSetMetaData {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/Product";
		String user="postgres";
		String password="root";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			
			String qry="select * from product";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qry);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			//no of colmn
			int n=rsmd.getColumnType(1);
			System.out.println(n);
			String type=rsmd.getColumnTypeName(1);
			System.out.println(type);
			int count=rsmd.getColumnCount();
			System.out.println(count);
			//column name
			String name=rsmd.getColumnName(2);
			System.out.println(name);
			
			String a=rsmd.getColumnLabel(5);
			System.out.println(a);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
