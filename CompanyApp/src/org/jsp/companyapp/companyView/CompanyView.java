package org.jsp.companyapp.companyView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jsp.companyapp.bean.Company;
import org.jsp.companyapp.controller.CompanyController;

public class CompanyView {
	
	static {
		System.out.println("<<<<==================WELCOME TO COMPANY APP======================>>>>");
	}
	
	public static Company enterCompanyData(Scanner sc,Company c)
	{
		System.out.println("Enter Company Id:");
		int id=sc.nextInt();
		System.out.println("Enter Company name:");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Company HeadQuarter:");
		String hqName=sc.nextLine();
		System.out.println("Enter Company CEO:");
		String ceo=sc.nextLine();
		System.out.println("Enter Company Services:");
		String services=sc.nextLine();
		System.out.println("Enter COmpany GST_NO:");
		String gst=sc.nextLine();
		System.out.println("Enter Company Rating:");
		String rating=sc.nextLine();
		
		c.setCompanyId(id);
		c.setCompanyName(name);
		c.setHeadQuarter(hqName);
		c.setCompanyCeoName(ceo);
		c.setCompanyServices(services);
		c.setCompanyGstNo(gst);
		c.setCompanyRating(rating);
		
		return c;
	}
	
	public static void display(Company c)
	{
		System.out.println("<<<================COMPANY DETAILS======================>>>");
		System.out.println("ID:"+c.getCompanyId());
		System.out.println("Name:"+c.getCompanyName());
		System.out.println("Head Quarters"+c.getHeadQuarter());
		System.out.println("CEO:"+c.getCompanyCeoName());
		System.out.println("Services:"+c.getCompanyServices());
		System.out.println("GST No:"+c.getCompanyGstNo());
		System.out.println("Rating:"+c.getCompanyRating());
		System.out.println("<<<======================================================>>>");
	}
	
	
	public static void main(String[] args) {
		CompanyController cc=new CompanyController();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\nEnter the choice:\n");
			System.out.println("1.Save Company\n2.Find Company\n3.Update Company\n4.Delete Company\n5.Sort By Name Asc\n6.Sort By Name Desc\n7.Exit\n");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				boolean b=cc.saveCompany(enterCompanyData(sc,new Company()));
				if(b)
					System.out.println("COMPANY RECORD INSERTED...!!");
				break;
			case 2:
				System.out.println("Enter User Company Id:");
				int companyId=sc.nextInt();
				Company c=cc.findCompanyById(companyId);
				if(c!=null)
					display(c);
				else
					System.out.println("RECORD NOT FOUND..!!!");
				
				break;
			case 3:
				System.out.println("Enter Company Id:");
				int ci=sc.nextInt();
				System.out.println("Enter Company Services:");
				sc.nextLine();
				String s=sc.nextLine();
				boolean b1=cc.updateCompanyById(ci, s);
				if(b1)
					System.out.println("RECORD UPDATED... !!");
				else
					System.out.println("RECORD NOT FOUND  !!");
				break;
			case 4:
				System.out.println("Enter Company Id");
				int id1=sc.nextInt();
				boolean b2=cc.deleteCompanyById(id1);
				if(b2)
					System.out.println("RECORD DELETED!!");
				else
					System.out.println("RECORD NOT FOUND!!");
				break;
			case 5:
				List<Company> l2=cc.sortByNameAsc();
				System.out.println(l2);
				break;
			case 6:
				List<Company> li=cc.sortByNameDesc();
				System.out.println(li);
				break;
			case 7:
				System.out.println("<<<======THANK YOU======>>>");
				return;

			default:
				break;
			}
		}		
	}

}
