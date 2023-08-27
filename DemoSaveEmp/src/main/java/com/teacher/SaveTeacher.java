package com.teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SaveTeacher {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/Teacher";
		String user = "postgres";
		String pass = "root";
		System.out.println("Eneter the row :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			for (int i = 1; i <= n; i++) {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the email");
				String email = sc.next();
				System.out.println("Enter the phone no");
				long phoneno = sc.nextLong();
				System.out.println("Enter the subject");
				String sub = sc.next();
				System.out.println("Enter the salary");
				long sal = sc.nextInt();
				System.out.println("Enter the degisnation");
				String deg = sc.next();
				String qry1 = "insert into teacher values("+id+",'"+name+"','"+email+"',"+phoneno+",'"+sub+"',"+sal+",'"+deg+"')";
				//INSERT INTO public.teacher VALUES (?, ?, ?, ?, ?, ?, ?);
				stmt.execute(qry1);
				System.out.println(i + " record inserted");
			}
			con.close();
			System.out.println("finally All record inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
