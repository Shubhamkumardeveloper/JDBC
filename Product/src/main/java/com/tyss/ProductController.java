package com.tyss;

import java.util.Scanner;

public class ProductController {
	public static void main(String[] args) {
		Product p=new Product();
		ProductDao pd=new ProductDao();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.insert_Data\n2.Find_Data\n3.Update_Data\n4.Delete_Data");
		System.out.println();
		System.out.println("Enter the Option");
		int n=sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter product id:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter product name:");
			String name=sc.nextLine();
			System.out.println("Enter product type:");
			String type=sc.next();
			System.out.println("Enter product description:");
			sc.nextLine();
			String desc=sc.nextLine();
			System.out.println("Enter product availability:");
			String avail=sc.nextLine();
			System.out.println("Enter product price:");
			double price=sc.nextDouble();
			
			p.setId(id);
			p.setName(name);
			p.setType(type);
			p.setDescription(desc);
			p.setAvailability(avail);
			p.setPrice(price);
			pd.saveProduct(p);
			break;
		case 2:
			System.out.println("Enter the id:");
			int id3=sc.nextInt();
			Product pf=pd.findProductById(id3);
			int id4=pf.getId();
			if(pf.getId()!=0)
			{
				System.out.println("id:"+id4);
				System.out.println("name:"+pf.getName());
				System.out.println("type:"+pf.getType());
				System.out.println("availability:"+pf.getAvailability());
				System.out.println("description:"+pf.getDescription());
				System.out.println("price:"+pf.getPrice());
			}
			else
				System.out.println("Record is not present..");
			
			break;
		case 3:
			System.out.println("Enter the id:");
			int id2=sc.nextInt();
			p.setId(id2);
			Product pu=pd.updateProductById(p);
			System.out.println("Availability updated to:"+pu.getAvailability());
			break;
		case 4:
			System.out.println("Enter the id:");
			int id_=sc.nextInt();
			p.setId(id_);
			int id1=p.getId();
			pd.removeProductById(id1);
			break;
		default:
			System.out.println("Invalid Option...");
			break;
		}
	
		
	}
}
