package edu.jsp.foodApp.model;

import java.util.Scanner;

import edu.jsp.foodApp.controller.ProductController;

public class FoodAppView {
	
	static {
		System.out.println("<<<======================WELCOME TO FOOD APP=========================>>>");
	}
	
	public static Product enterProductData(Scanner read)
	{
		Product product=new Product();
		System.out.println("Enter Product Id:");
		int pid=read.nextInt();
		System.out.println("Enter Product Name:");
		read.nextLine();
		String pname=read.nextLine();
		System.out.println("Enter Product Description:");
		String pdesc=read.nextLine();
		System.out.println("Enter Product Price:");
		double price=read.nextDouble();
		System.out.println("Enter Order Id:");
		int oid=read.nextInt();
		product.setProductId(pid);
		product.setProductName(pname);
		product.setProductDescription(pdesc);
		product.setProductPrice(price);
		product.setOrderId(oid);
		return product;
	}
	
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		ProductController productController=new ProductController();
		while(true)
		{
			System.out.println("Eneter the choice:\n");
			System.out.println("1.Save Product\n2.Fetch Order By OrderId\n3.Update Order by OrderId\n4.Remove Order By OrderId\n5.exit\n");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				Product product=enterProductData(read);
				Order o=productController.saveProduct(product);
				System.out.println("RECORD INSERTED...\n");
				System.out.println("Your Order Id: "+o.getOrderId()+" & OrderNumber: "+o.getOrderNumber()+"\n");
				break;
			case 2:
				System.out.println("Enter Order Id:");
				int oid=read.nextInt();
				productController.findProductByOrderId(oid);
				break;
			case 3:
				System.out.println(choice);
				break;
			case 4:
				System.out.println("Enter Order Id");
				break;
			case 5:
				System.out.println("<<================THANK YOU==================>>");
				return;
			default:
				System.out.println("INVALID CHOICE..");
				break;
			}
			
		}
		
		
	}

}
