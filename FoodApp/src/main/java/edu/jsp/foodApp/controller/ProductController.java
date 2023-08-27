package edu.jsp.foodApp.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import edu.jsp.foodApp.model.Order;
import edu.jsp.foodApp.model.Product;
public class ProductController {
	OrderController oc=new OrderController();
	public  Order saveProduct(Product p)
	{
		Order o=new Order();
		o.setOrderId(p.getOrderId());
		o.setOrderNumber(p.getProductId()+""+p.getProductName());
		try {
			FileInputStream fStream=new FileInputStream("food.properties");
			Properties properties=new Properties();
			properties.load(fStream);
			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, properties);
			CallableStatement cStatement=con.prepareCall("call create_product_records(?,?,?,?,?)");
			cStatement.setInt(1,p.getProductId());
			cStatement.setString(2,p.getProductName());
			cStatement.setString(3,p.getProductDescription());
			cStatement.setDouble(4,p.getProductPrice());
			cStatement.setInt(5,p.getOrderId());
			cStatement.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		oc.saveOrder(o);
		return o;
	}
	
	public static void findProductByOrderId(int oid)
	{
		Connection con=null;
		try {
			FileInputStream fStream=new FileInputStream("food.properties");
			Properties properties=new Properties();
			properties.load(fStream);
			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			Class.forName(driver);
			con=DriverManager.getConnection(url, properties);
			String sql="select * from product where \"OrderId\"=?";
			PreparedStatement pStatement=con.prepareStatement(sql);
			pStatement.setInt(1,oid);
			ResultSet rSet=pStatement.executeQuery();
			while(rSet.next())
			{
				System.out.println("Product id:"+rSet.getInt(1));
				System.out.println("Product name:"+rSet.getString(2));
				System.out.println("Product Description:"+rSet.getString(3));
				System.out.println("Product price:"+rSet.getDouble(4));
				System.out.println("Order Id:"+rSet.getInt(5));
			}
		} catch (Exception e) {
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
