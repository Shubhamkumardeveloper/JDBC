package com.jdbc;

public class StuMain {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.jdbc.Student");
			System.out.println(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

