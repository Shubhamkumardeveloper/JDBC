package edu.tyss.userapp.view;
import java.util.*;
import edu.tyss.userapp.bean.User;
import edu.tyss.userapp.controller.UserController;
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
		user.setUserId(id);
		user.setUserName(name);
		user.setUserEmail(email);
		return user;
	}
	
	public static void converStringUserIntoUserObject(List<String> al)
	{
		for(int i=0;i<al.size();i++)
		{
			String s=(String)al.get(i);
			String[] s1=s.split(",");
			User u=new User();
			u.setUserId(Integer.parseInt((s1[0].split("="))[1]));
			u.setUserName(((s1[1].split("="))[1]));
			u.setUserEmail(((s1[2].split("="))[1]));
			System.out.println("======================");
			System.out.println("Id:"+u.getUserId());
			System.out.println("Name:"+u.getUserName());
			System.out.println("Email:"+u.getUserEmail());
			System.out.println("======================\n");
		}
	}
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		UserController uc=new UserController();
		while(true)
		{
			System.out.println("\nEnter the Option");
			System.out.println("1.Add_User\n2.Find_User\n3.Exit");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				uc.saveUser(enterUserData(read));
				break;

			case 2:
				converStringUserIntoUserObject(uc.findAllUsers());
				break;
			case 3:
				return;
			default:
				break;
			}
			
		}
		
	}
}
