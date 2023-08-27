package com.teacher;
import java.sql.*;
public class FetchDat {
	public static void main(String[] args) {
		String qry="SELECT * FROM Teacher";
		try {
			Class.forName("org.postgresql.Driver");
			try {
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Teacher?user=postgres&password=root");
				Statement stm=con.createStatement();
				ResultSet rs= stm.executeQuery(qry);
				while(rs.next())
				{
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String email=rs.getString(3);
					long phone_no=rs.getLong(4);
					String subject=rs.getString(5);
					long salary=rs.getLong(6);
					String deg=rs.getString(7);
					
					System.out.println("=============================");
					System.out.println(id);
					System.out.println(name);
					System.out.println(email);
					System.out.println(phone_no);
					System.out.println(subject);
					System.out.println(salary);
					System.out.println(deg);
					System.out.println("=============================");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
