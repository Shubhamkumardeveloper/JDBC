package edu.jsp.userapp.userView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import edu.jsp.userapp.Controller.UserController;
import edu.jsp.userapp.model.User;
public class UserView {
	static {
		System.out.println("<<<=============Welcome To User App===============>>>");
	}
	
	public static User enterUserData(Scanner read) {
		System.out.println("Enter User Id:");
		int id=read.nextInt();
		System.out.println("Enter User Name:");
		read.nextLine();
		String name=read.nextLine();
		System.out.println("Enter User Email:");
		String email=read.nextLine();
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		return user;
	}
	
	public static void converStringUserIntoUserObject(List<String> al)
	{
		for(int i=1;i<al.size();i++)
		{
			User u=new User();
			String s=al.get(i);
			String[] s1=s.split(",");
			u.setId(Integer.parseInt(s1[0]));
			u.setName(s1[1]);
			u.setEmail(s1[2]);
			display(u);
		}
	}
	
	public static void display(User u)
	{
		System.out.println("<<<<===========User Details========>>>>");
		System.out.println("Id:"+u.getId());
		System.out.println("Name:"+u.getName());
		System.out.println("Email:"+u.getEmail());
		System.out.println("<<<<=============================>>>>\n");
	}
	
	public static void sortByIdDesc(List<String> al,UserController uc)
	{
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<al.size();i++)
		{
			String s=al.get(i);
			String[] s1=s.split(",");
			int id=Integer.parseInt(s1[0]);
			list.add(id);
		}
		Collections.sort(list);
		for(Integer o:list)
		{
			int id=o;
			User u=uc.findById(id,al);
			if(u!=null)
				display(u);
		}
	}
	
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		UserController uc=new UserController();
		while(true)
		{
			System.out.println("\nEnter the Option");
			System.out.println("1.Add_User\n2.Find_User\n3.Find\n4.Sort_By_Id");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				uc.saveUser(enterUserData(read));
				System.out.println("RECORD INSERTED SUCCESFULLY  !!");
				break;

			case 2:
				converStringUserIntoUserObject(uc.findAllUser());
				break;
			case 3:
				System.out.println("Enter User Id:");
				int id=read.nextInt();
				User u=uc.findById(id,uc.findAllUser());
				if(u!=null)
					display(u);
				else
					System.out.println("Record Not Found  !!");
				break;
			case 4:
				List al=uc.findAllUser();
				sortByIdDesc(al,uc);
				break;
			case 5:
				System.out.println("<<<========THANK YOU=======>>>");
				return;
			default:
				break;
			}
			
		}
		
	}

}
