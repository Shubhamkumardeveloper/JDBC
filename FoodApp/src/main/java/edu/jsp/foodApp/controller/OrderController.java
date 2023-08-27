package edu.jsp.foodApp.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import edu.jsp.foodApp.model.Order;

public class OrderController {

	public void saveOrder(Order o) {
		try {
			FileInputStream fStream = new FileInputStream("food.properties");
			Properties properties = new Properties();
			properties.load(fStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, properties);
			String sql = "INSERT INTO orders VALUES(?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1,o.getOrderId());
			pStatement.setString(2, o.getOrderNumber());
			pStatement.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
