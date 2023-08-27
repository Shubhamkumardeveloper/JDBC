package com.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveEmp {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/Employee";
		String user="postgres";
		String pass="root";
		try {
			//step 1
			Class.forName("org.postgresql.Driver");
			//create a connection
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println(con);
			//create a platform
			Statement stmt= con.createStatement();
			
			//insert the data..
			String qry0="insert into Emp values(1,'SHUBHAM KUMAR','shubhamkrsam1809@gmail.com','ASE',8789982015,'JDBC','1000','shubu@123')";
			stmt.execute(qry0);
			String qry1="insert into Emp values(2,'SHUBHAM KUMAR','shubhamkrsam1809@gmail.com','ASE',8789982015,'JDBC','1000','shubu@123')";
			stmt.execute(qry1);
			String qry2="insert into Emp values(3,'SHUBHAM KUMAR','shubhamkrsam1809@gmail.com','ASE',8789982015,'JDBC','1000','shubu@123')";
			stmt.execute(qry2);
			String qry3="insert into Emp values(4,'SHUBHAM KUMAR','shubhamkrsam1809@gmail.com','ASE',8789982015,'JDBC','1000','shubu@123')";
			stmt.execute(qry3);
			String qry4="insert into Emp values(5,'SHUBHAM KUMAR','shubhamkrsam1809@gmail.com','ASE',8789982015,'JDBC','1000','shubu@123')";
			stmt.execute(qry4);
			//update the data
			String qry="update emp set name='ANJESH KUMAR',phone_no=6207070063 where id=2";
			stmt.execute(qry);
			System.out.println("Record Updated");
			//delete a record
			String qry5="delete from emp where id=1";
			stmt.execute(qry5);
			System.out.println("Record deleted...");
			con.close();
			System.out.println("DATA IS INSERTED");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
