package edu.jsp.userapp.view;

import java.util.Scanner;

import edu.jsp.userapp.bean.User;
import edu.jsp.userapp.controller.UserController;

public class UserView {
	
	static {
		System.out.println("<<============Welcome To UserApp============>>");
	}
	
	public static User enterUserData(Scanner sc,User u)
	{
		System.out.println("Enter User Id:");
		int id=sc.nextInt();
		System.out.println("Enter User Name:");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter User Email");
		String email=sc.nextLine();
		System.out.println("Enter User PhoneNumber:");
		long phoneNo=sc.nextLong();
		System.out.println("Enter User Age:");
		int age=sc.nextInt();
		u.setUserId(id);
		u.setUserName(name);
		u.setUserEmail(email);
		u.setUserPhoneNumber(phoneNo);
		u.setUserAge(age);
		return u;
	}
	public static void display(User u)
	{
		System.out.println("\n<<================== User Details:======================>>\n");
		System.out.println("Id:"+u.getUserId());
		System.out.println("Name:"+u.getUserName());
		System.out.println("Email:"+u.getUserEmail());
		System.out.println("PhoneNumber:"+u.getUserPhoneNumber());
		System.out.println("Age:"+u.getUserAge());
		System.out.println("\n<<============================================================>>\n");
	}
	public static void main(String[] args) {
		
		UserController uc=new UserController();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\nEnter the choice:\n");
			System.out.println("1.Save User\n2.Find User\n3.Update User\n4.Delete User\n");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				uc.saveUser(enterUserData(sc,new User()));
				System.out.println("User record Inserted ..... !!");
				break;
			case 2:{
				System.out.println("Enter User Id:");
				int id=sc.nextInt();
				User user=uc.findUserById(id);
				if(user!=null)
					display(user);
				else
					System.out.println("User Not Found !!!");
			}
				break;
			case 3:
				System.out.println("Enter User Id:");
				int id1=sc.nextInt();
				System.out.println("Enter User New Age:");
				int age=sc.nextInt();
				boolean b=uc.UpdateUserById(id1, age);
				if(b)
					System.out.println("User record updated !!");
				else
					System.out.println("User Not Found !!");
				break;
			case 4:
				System.out.println("Enter User Id:");
				int id2=sc.nextInt();
				boolean b1=uc.deleteUserById(id2);
				if(b1)
					System.out.println("User Record deleted !!");
				else
					System.out.println("User Not Found !!");
				
				break;
			case 5:
				System.out.println("<<<======THANK YOU======>>>");
				return;
			default:
				break;
			}
		}		
	}

}
