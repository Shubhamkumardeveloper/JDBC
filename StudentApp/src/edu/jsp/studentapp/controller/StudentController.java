package edu.jsp.studentapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.jsp.studentapp.bean.Student;
public class StudentController {
	
	private static List<Student> studentList=new ArrayList<Student>(); 
	
	
	
	public void saveStudent(Student student) {
		studentList.add(student);
		System.out.println("Record Save\n");
	}
	
	public  Student findStudentById(int studentId)
	{
		for(Student student:studentList)
		{
			if(student.getStudentId()==studentId)
				return student;
		}
		return null;
	}
	
	public  Student updateStudentById(int studentId,int studentAge)
	{
		Student student=findStudentById(studentId);
		if(student!=null)
		{
			student.setAge(studentAge);
			return student;
		}
		return null;
	}
	
	public String deleteStudentById(int studentId)
	{
		Student student=findStudentById(studentId);
		if(student!=null)
		{
			studentList.remove(student);
			return "Record Deleted";
		}
		return "Student record not found!!!";
	}

}
