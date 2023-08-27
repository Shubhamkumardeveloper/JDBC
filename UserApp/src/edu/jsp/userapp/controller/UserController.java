package edu.jsp.userapp.controller;

import java.util.HashMap;
import java.util.Map;
import edu.jsp.userapp.bean.User;

public class UserController {

	/*
	 * Creating a Map
	 * @author: SHUBHAM KUMAR
	 * @date:2023-07-07
	 * */
	
	private static Map<Integer,User> userMap=new HashMap<Integer, User>();
	
	/*
	 * This is Method is used to save the user record into HashMap. 
	 * @author: SHUBHAM KUMAR
	 * @date:2023-07-07
	 * */
	
	public void saveUser(User user)
	{
		userMap.put(user.getUserId(),user);
	}
	
	/*
	 * This is Method is used to find the user record from the HashMap. 
	 * @author: SHUBHAM KUMAR
	 * @date:2023-07-07
	 * */
	public User findUserById(int id)
	{
		if(userMap.get(id)!=null)
			return userMap.get(id);
		
		return null;
				
	}
	
	/*
	 * This is Method is used to Update the user record from the HashMap. 
	 * @author: SHUBHAM KUMAR
	 * @date:2023-07-07
	 * */
	public boolean UpdateUserById(int id,int age)
	{
		User u=findUserById(id);
		if(u!=null)
		{
			u.setUserAge(age);
			return true;
		}
		return false;
	}
	
	/*
	 * This is Method is used to delete the user record from the HashMap. 
	 * @author: SHUBHAM KUMAR
	 * @date:2023-07-07
	 * */
	public boolean deleteUserById(int id)
	{
		User u=findUserById(id);
		if(u!=null)
		{
			userMap.remove(u.getUserId());
		    return true;
		}
		return false;
	}
}
