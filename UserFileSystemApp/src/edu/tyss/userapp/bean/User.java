package edu.tyss.userapp.bean;

import java.io.Serializable;

public class User implements Serializable
{
	private int userId;
	private String userName;
	private String userEmail;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "userId=" + userId + ",userName=" + userName + ",userEmail=" + userEmail + "\n";
	}
}
