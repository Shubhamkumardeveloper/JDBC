package edu.tyss.login;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LoginPassword {
	
	public static  String key = "ThisIsASecretKey";
	
    public static String encrypt(String plaintext, String key) throws Exception {
        // Create a SecretKeySpec using the provided key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

        // Create a cipher instance for AES
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // Encode the encrypted bytes as Base64
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedText;
    }

    public static String decrypt(String encryptedText, String key) throws Exception {
        // Create a SecretKeySpec using the provided key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

        // Create a cipher instance for AES
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decode the Base64 encrypted text
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

        // Decrypt the encrypted bytes
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert the decrypted bytes to plaintext
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

        return decryptedText;
    }
    
    public static void saveLogin(String userName,String password)
    {
    	try {
    		String pass=encrypt(password, key);
    		FileInputStream fis=new FileInputStream("login.properties");
        	Properties p=new Properties();
        	p.load(fis);
        	String url=p.getProperty("url");
        	Connection con=DriverManager.getConnection(url,p);
        	String sql="insert into login values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2,pass);
			ps.execute();
			con.close();
        	System.out.println("record inserted..");
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    
    public static void findLogin()
    {
    	try {
    		FileInputStream fis=new FileInputStream("login.properties");
        	Properties p=new Properties();
        	p.load(fis);
        	String url=p.getProperty("url");
        	Connection con=DriverManager.getConnection(url,p);
        	String sql="Select * from login";
        	Statement st=con.createStatement();
        	ResultSet rs=st.executeQuery(sql);
        	while(rs.next())
        	{
        		
        		System.out.println("UserName is: "+rs.getString(1));
        		String pass=rs.getString(2);
        		String p1=decrypt(pass, key);
        		System.out.println("Password: "+p1+"\n");
        	}
        	con.close();
        	
		} catch (Exception e) {
		}
    }
    

    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
    	while(true)
    	{
    		System.out.println("Enter choice:");
    		System.out.println("1.Login\n2.find\n3.Exit\n");
    		int choice=scanner.nextInt();
    		switch (choice) {
			case 1:
				System.out.println("Enter UserName:");
		    	String userName=scanner.nextLine();
		    	System.out.println("Enter Password:");
		    	String password=scanner.nextLine();
		    	saveLogin(userName, password);
				break;
				
            case 2:
            	findLogin();
				break;
            case 3:
				System.out.println("THANK YOU..");
				return;

			default:
				break;
			}
    	}
    }
}
