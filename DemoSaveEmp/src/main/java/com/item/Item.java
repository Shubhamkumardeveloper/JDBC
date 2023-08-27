package com.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Item {
	public static void main(String[] args) {
		//id,name,quantity,price,manufature
		String Driver="org.postgresql.Driver";
		String userName="postgres";
		String password="root";
		String url="jdbc:postgresql://localhost:5432/Item";
		//insert
		String qry="insert into item values(1,'Pen',2,20,'writermetter')";
		String qry1="insert into item values(2,'Book',5,200,'Sun_Micro')";
		//Update
		String update="update item set quantity=6 where id=1";
		//delete
		String delet="delete from item where id=2";
		
		try {
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(url, userName, password);
			Statement stmt=con.createStatement();
			stmt.execute(delet);
			con.close();
			System.out.println("Item inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
