package edu.tyss.userapp.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.tyss.userapp.bean.User;

public class UserController {
	
	private static String filePath="C:\\Users\\Admin\\Desktop\\JDBC TYSS\\User\\UserFileSystemApp\\src\\userInfo.txt";
	
	public static void  saveUser(User u)
	{
		try {
			FileOutputStream fos=new FileOutputStream(filePath,true);
			byte[] user=u.toString().getBytes();
			fos.write(user);
			fos.close();
			System.out.println("User record saved");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static List findAllUsers()
	{
		List<String> listOfSring=new ArrayList<String>();
		try {
			FileInputStream fis=new FileInputStream(filePath);
			InputStreamReader inr=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(inr);
			String line="";
			while((line=reader.readLine())!=null)
			{
				listOfSring.add(line);
			}
			
		} catch (Exception  e) {
			e.printStackTrace();
		}
		return listOfSring;
	}
}
