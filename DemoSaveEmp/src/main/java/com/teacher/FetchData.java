package com.teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/Teacher";
		String user="postgres";
		String password="root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String sql="Select * from teacher";
			Statement stm=con.createStatement();
			ResultSet re=stm.executeQuery(sql);
			while(re.next())
			{
				int id=re.getInt(1);
				String name=re.getString(2);
				String email=re.getString(3);
				long phoneno=re.getLong(4);
				String subjet=re.getString(5);
				long salary=re.getLong(6);
				String deg=re.getString(7);
				
				System.out.println("----------------");
				System.out.println("id:"+id);
				System.out.println("name:"+name);
				System.out.println("email:"+email);
				System.out.println("phone no:"+phoneno);
				System.out.println("subject:"+subjet);
				System.out.println("salary:"+salary);
				System.out.println("degisnation:"+deg);
				System.out.println("----------------");
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
