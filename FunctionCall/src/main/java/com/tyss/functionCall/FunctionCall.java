package com.tyss.functionCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionCall {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/student";
		String user="postgres";
		String password="root";
		String driver="org.postgresql.Driver";
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			CallableStatement cstm=con.prepareCall("select count_by_gender(?)");
			
			cstm.setString(1,"male");
			ResultSet rs=cstm.executeQuery();
			
			if(rs.next())
				System.out.println(rs.getInt(1));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
