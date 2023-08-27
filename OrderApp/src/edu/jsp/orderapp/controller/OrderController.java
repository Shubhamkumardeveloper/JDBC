package edu.jsp.orderapp.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.jsp.orderapp.model.Order;

public class OrderController {
	private static String filePath="C:\\Users\\Admin\\Desktop\\JDBC TYSS\\User\\OrderApp\\src\\order.csv";
	
	public void saveOrder(Order o)
	{
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(filePath,true);
			byte[] b=o.toString().getBytes();
			fileOutputStream.write(b);
			System.out.println("RECORD INSERTED..");
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  List findAllUser()
	{
		List<String> list=new ArrayList();
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String line="";
			while((line=br.readLine())!=null)
			{
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
