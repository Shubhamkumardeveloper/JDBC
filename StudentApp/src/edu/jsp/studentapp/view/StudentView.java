package edu.jsp.studentapp.view;

import java.util.Scanner;

import edu.jsp.studentapp.bean.Student;
import edu.jsp.studentapp.controller.StudentController;

public class StudentView {
	
	public static Student enterStudentData(Scanner scanner,Student student)
	{
		System.out.println("Enter Student Id:");
		int sid=scanner.nextInt();
		System.out.println("Enter Student Name:");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.println("Enter Student PhoneNumber:");
		long phoneNumber=scanner.nextLong();
		System.out.println("Enter Student Gender");
		scanner.nextLine();
		String gender=scanner.nextLine();
		System.out.println("Enter Student Age:");
		int age=scanner.nextInt();
		
		student.setStudentId(sid);
		student.setStudentName(name);
		student.setStudentPhoneNumber(phoneNumber);
		student.setStudentGender(gender);
		student.setAge(age);
		return student;
		
	}
	
	static {
		System.out.println("<=========Welwcome To StudentApp=============>\n\n");
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Student student=new Student();
		StudentController uc=new StudentController();
		while(true)
		{
			System.out.println("Enter the option");
			System.out.println(".................\n");
			System.out.println("1.Save\n2.Find\n3.Update\n4.Delete\n5.Exit");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				 	Student student1=enterStudentData(scanner,student);
				 	uc.saveStudent(student1);
				break;
			case 2:
					System.out.println("Enter student Id:");
					int sid=scanner.nextInt();
					Student sf=uc.findStudentById(sid);
					if(sf!=null)
					{
						System.out.println("===========Student Details===============");
						System.out.println("Id:"+sf.getStudentId());
						System.out.println("Name:"+sf.getStudentName());
						System.out.println("PhoneNumber"+sf.getStudentPhoneNumber());
						System.out.println("Gender:"+sf.getStudentGender());
						System.out.println("Age:"+sf.getAge());
						System.out.println("==========================================\n\n");
					}
					else
						System.out.println("No Record Found!!");
				break;
			case 3:
					System.out.println("Enter Student Id:");
					int id=scanner.nextInt();
					System.out.println("Enter the New Age:");
					int age=scanner.nextInt();
					Student su=uc.updateStudentById(id, age);
					if(su!=null)
					{
						System.out.println("===========Student New Details===============");
						System.out.println("Id:"+su.getStudentId());
						System.out.println("Name:"+su.getStudentName());
						System.out.println("PhoneNumber"+su.getStudentPhoneNumber());
						System.out.println("Gender:"+su.getStudentGender());
						System.out.println("Age:"+su.getAge()+"\n");
						System.out.println("==========================================\n\n");
					}
					else
						System.out.println("No Record Found!!");
				break;
			case 4:
				System.out.println("Enter Student Id");
				int sid1=scanner.nextInt();
				System.out.println(uc.deleteStudentById(sid1));
				break;
			case 5:
					System.out.println("THANK YOU !!");
					return;
			default:
				break;
			}
		}
	}
}
