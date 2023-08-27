package com.transactionmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TestFirst {
	public static void main(String[] args) {
		Connection con=ConnectionPool.getConnectionObject();
		String sqlBook_info="insert into booking_info values(1,'AIR-IND-101','BGP','BANGLORE')";
		
		String sqlPass_info1="insert into passenger_info values(1,'priya',22,'female')";
		String sqlPass_info2="insert into passenger_info values(2,'dimple',23,'female')";
		String sqlPass_info3="insert into passenger_info values(3,'Raju',21,'male')";
		
		String sqlPay_info="insert into payment_info values(1,1,250000,7000,'requested')";
		try {
			
			con.setAutoCommit(false);
			
			Statement st1=con.createStatement();
			st1.execute(sqlBook_info);
			
			Savepoint savp=con.setSavepoint();
			
			Statement st2=con.createStatement();
			st2.execute(sqlPass_info1);
			
			Statement st3=con.createStatement();
			st3.execute(sqlPass_info2);
			
			Statement st4=con.createStatement();
			st4.execute(sqlPass_info3);
			
			if(DemoPaymentGateway.isSucces())
			{
				Statement st5=con.createStatement();
				st5.execute(sqlPay_info);
				con.commit();
				System.out.println("Transaction Completed..");
			}
			else
			{
				con.rollback(savp);
				con.commit();
				System.out.println("Transaction failed , data reverted");
			}
			
			ConnectionPool.receiveConnectionObject(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
