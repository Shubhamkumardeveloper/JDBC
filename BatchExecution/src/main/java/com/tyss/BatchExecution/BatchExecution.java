package com.tyss.BatchExecution;
import java.sql.*;
public class BatchExecution {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "root";
		String Driver = "org.postgresql.Driver";

		try {
			Class.forName(Driver);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stm = con.createStatement();
			
			String sql = "insert into id_card values(109,'sheela',8789982015,'AB+')";
			String sql1 = "update id_card set name='Ram' where id=101";
			String sql2 = "Delete from id_card where id=101";
			
			//Adding to batch
			stm.addBatch(sql);
			stm.addBatch(sql1);
			stm.addBatch(sql2);
			//returnType
			int [] a=stm.executeBatch();
			for(int i:a)
				System.out.println(i);
			
			con.close();
			System.out.println("Completed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
