package com.tyss.employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class EmpDao {
	public void saveEmp(EmployeEncap e1)
	{
		int id=e1.getId();
		String name=e1.getName();
		String email=e1.getEmail();
		long phone=e1.getPhone();
		String gender=e1.getGender();
		try {
			FileInputStream fis=new FileInputStream("employee.properties");
			Properties p=new Properties();
			p.load(fis);
			String url=p.getProperty("url");
			String driver=p.getProperty("driver");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,p);
			
			CallableStatement cstm=con.prepareCall("call create_employee_records(?,?,?,?,?)");
			cstm.setInt(1,id);
			cstm.setString(2,name);
			cstm.setString(3,email);
			cstm.setLong(4,phone);
			cstm.setString(5,gender);
			cstm.execute();
			con.close();
			System.out.println("Inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findEmpById(EmployeEncap e1)
	{
		int id=e1.getId();
		
		try {
			FileInputStream fis=new FileInputStream("employee.properties");
			Properties p=new Properties();
			p.load(fis);
			String url=p.getProperty("url");
			String driver=p.getProperty("driver");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,p);
			CallableStatement cstm=con.prepareCall("call find_employee_records(?,?,?,?,?)");
			cstm.setInt(1,id);
			cstm.registerOutParameter(1,Types.INTEGER);
			cstm.registerOutParameter(2,Types.VARCHAR);
			cstm.registerOutParameter(3,Types.VARCHAR);
			cstm.registerOutParameter(4,Types.BIGINT);
			cstm.registerOutParameter(5,Types.VARCHAR);
			
			cstm.execute();
			
			System.out.println("id:"+cstm.getInt(1));
			System.out.println("name:"+cstm.getString(2));
			System.out.println("email:"+cstm.getString(3));
			System.out.println("phone:"+cstm.getLong(4));
			System.out.println("gender:"+cstm.getString(5));
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmpById(EmployeEncap e1)
	{
		int id=e1.getId();
		
		try {
			FileInputStream fis=new FileInputStream("employee.properties");
			Properties p=new Properties();
			p.load(fis);
			String url=p.getProperty("url");
			String driver=p.getProperty("driver");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,p);
			CallableStatement cstm=con.prepareCall("call delete_employee_records(?)");
			cstm.setInt(1,id);
			cstm.execute();
			con.close();
			System.out.println("deleted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateEmpById(EmployeEncap e1)
	{
		int id=e1.getId();
		String email=e1.getEmail();
		
		try {
			FileInputStream fis=new FileInputStream("employee.properties");
			Properties p=new Properties();
			p.load(fis);
			String url=p.getProperty("url");
			String driver=p.getProperty("driver");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,p);
			CallableStatement cstm=con.prepareCall("call update_employee_records(?,?)");
			cstm.setString(1,email);
			cstm.setInt(2,id);
			cstm.execute();
			con.close();
			System.out.println("Updated");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EmployeEncap e=new EmployeEncap();
		EmpDao ed=new EmpDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.insert_Data\n2.Find_Data\n3.Update_Data\n4.Delete_Data");
		System.out.println();
		System.out.println("Enter the Option");
		int n=sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter id:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name:");
			String name=sc.nextLine();
			System.out.println("String Email:");
			String email=sc.next();
			System.out.println("Enter phoneNumber:");
			long phoneNumber=sc.nextLong();
			System.out.println("Enter gender:");
			String gender=sc.next();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setPhone(phoneNumber);
			e.setGender(gender);
			ed.saveEmp(e);
			break;
		case 2:
			System.out.println("Enter the id:");
			int id___=sc.nextInt();
			e.setId(id___);
			ed.findEmpById(e);
			break;
		case 3:
			System.out.println("Enter the id:");
			int id_=sc.nextInt();
			System.out.println("Enter new Email:");
			String email_=sc.next();
			e.setId(id_);
			e.setEmail(email_);
			ed.updateEmpById(e);
			break;
		case 4:
			System.out.println("Enter the id:");
			int id__=sc.nextInt();
			e.setId(id__);
			ed.deleteEmpById(e);
			break;
		default:
			System.out.println("Invalid Option...");
			break;
		}
	}

}
