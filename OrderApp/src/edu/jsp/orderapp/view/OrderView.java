package edu.jsp.orderapp.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.jsp.orderapp.controller.OrderController;
import edu.jsp.orderapp.model.Order;

public class OrderView {
	
	public static Order enterOrderData(Scanner read)
	{
		System.out.println("Enter Order id:");
		int id=read.nextInt();
		System.out.println("Enter Food Name:");
		read.nextLine();
		String name=read.nextLine();
		System.out.println("Enter Food price:");
		int price=read.nextInt();
		System.out.println("Enter Quantity:");
		int quantity=read.nextInt();
		System.out.println("Enter GST %:");
		int gst=read.nextInt();
		int totalAmount=(price*quantity)+((price*quantity)*gst/100);
		Order o=new Order();
		o.setOrderId(id);
		o.setOrderFoodName(name);
		o.setPrice(price);
		o.setQuantity(quantity);
		o.setGstPerc(gst);
		o.setTotalAmount((int)totalAmount);
		return o;
	}
	
	public static void converStringUserIntoUserObject(List<String> al)
	{
		for(int i=1;i<al.size();i++)
		{
			Order o=new Order();
			String s=al.get(i);
			String[] s1=s.split(",");
			o.setOrderId(Integer.parseInt(s1[0]));
			o.setOrderFoodName(s1[1]);
			o.setPrice(Integer.parseInt(s1[2]));
			o.setQuantity(Integer.parseInt(s1[3]));
			o.setGstPerc(Integer.parseInt(s1[4]));
			o.setTotalAmount(Integer.parseInt(s1[5]));
			display(o);
		}
	}
	
	public static void display(Order o)
	{
		System.out.println("<<<<===========Order Details========>>>>");
		System.out.println("Order Id:"+o.getOrderId());
		System.out.println("Food Name:"+o.getGstPerc());
		System.out.println("Price:"+o.getPrice());
		System.out.println("Quantity:"+o.getQuantity());
		System.out.println("GST%:"+o.getGstPerc());
		System.out.println("Total Amount:"+o.getTotalAmount());
		System.out.println("<<<<=============================>>>>\n");
	}
	
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		OrderController oc=new OrderController();
		while(true)
		{
			System.out.println("Enter option:");
			System.out.println("1.Save_Order\n2.Find_All_Order\n3.Find_By_OrderID\n4.Exit");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				Order o=enterOrderData(read);
				oc.saveOrder(o);
				System.out.println("Record Inserted ...!!!");
				break;
				
			case 2:
				List list=oc.findAllUser();
				converStringUserIntoUserObject(list);
				break;
			case 3:
				System.out.println(choice);
				break;
			case 4:
				System.out.println("========================THANK YOU==========================");
				return;

			default:
				break;
			}
			
		}
	}

}
