package com.tyss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class ProductDao {
	public void saveProduct(Product p)
	{
		int id=p.getId();
		String name=p.getName();
		String type=p.getType();
		String desc=p.getDescription();
		String avail=p.getAvailability();
		double price=p.getPrice();
		try {
			FileInputStream fis = new FileInputStream("product.properties");
			Properties property=new Properties();
			property.load(fis);
			String url=property.getProperty("url");
			Connection con=DriverManager.getConnection(url,property);
			CallableStatement cs=con.prepareCall("call create_product_records(?,?,?,?,?,?)");
			cs.setInt(1, id);
			cs.setString(2,name);
			cs.setString(3, type);
			cs.setString(4,desc);
			cs.setString(5, avail);
			cs.setDouble(6,price);
			
			cs.execute();
			
			System.out.println("Inserted");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Product findProductById(int id)
	{
		Product p=null;
		try {
			FileInputStream fis = new FileInputStream("product.properties");
			Properties property=new Properties();
			property.load(fis);
			
			String url=property.getProperty("url");
			
			Connection con=DriverManager.getConnection(url,property);
			
			CallableStatement cs=con.prepareCall("call find_product_records(?,?,?,?,?,?)");
			
			cs.setInt(1,id);
			
			cs.registerOutParameter(1,Types.INTEGER);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.DOUBLE);
			
			cs.execute();
			
			p=new Product();
			p.setId(cs.getInt(1));
			p.setName(cs.getString(2));
			p.setType(cs.getString(3));
			p.setDescription(cs.getString(4));
			p.setAvailability(cs.getString(5));
			p.setPrice(cs.getDouble(6));

			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return p;
	}
	
	public Product updateProductById(Product p) 
	{
		int id=p.getId();
        String qry="select * from product where id=?";
        try {
        FileInputStream fis = new FileInputStream("product.properties");
		Properties property=new Properties();
		property.load(fis);
		String url=property.getProperty("url");
		Connection con=DriverManager.getConnection(url,property);
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setInt(1,p.getId());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("Enter the new Availability:");
			String avail=new Scanner(System.in).nextLine();
			CallableStatement cs=con.prepareCall("call update_product_records(?,?)");
			cs.setString(1,avail);
			cs.setInt(2, id);
			cs.execute();
			con.close();
			System.out.println("Updated");
			p=findProductById(id);
		}
		else
			System.out.println("No Record Available....");
        }
        catch(Exception e)
        {
        	
        }
		return p;
	}
	
	public void removeProductById(int id)
	{
		try {
			FileInputStream fis = new FileInputStream("product.properties");
			Properties property=new Properties();
			property.load(fis);
			
			String url=property.getProperty("url");
			
			Connection con=DriverManager.getConnection(url,property);
			CallableStatement cs=con.prepareCall("call delete_product_records(?)");
			cs.setInt(1,id);
			cs.execute();
			
			con.close();
			System.out.println("Deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
