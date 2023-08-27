package edu.jsp.userapp.Controller;
import java.io.*;
import java.util.*;
import edu.jsp.userapp.model.User;
public class UserController {
	
	private static String filePath="C:\\Users\\Admin\\Desktop\\JDBC TYSS\\User\\UserApp_csv\\src\\user.csv";
	
	public  void saveUser(User u)
	{
		try {
			FileOutputStream fis=new FileOutputStream(filePath,true);
			byte[] b=u.toString().getBytes();
			fis.write(b);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  List findAllUser()
	{
		List<String> list=new ArrayList();
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String line="";
			while((line=br.readLine())!=null)
			{
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static User findById(int id,List<String> al)
	{
		for(int i=1;i<al.size();i++)
		{
			String s=al.get(i);
			String[] s1=s.split(",");
			int id1=Integer.parseInt(s1[0]);
			if(id==id1)
			{
				User u=new User();
				u.setId(id1);
				u.setName(s1[1]);
				u.setEmail(s1[2]);
				return u;
			}
		}
		return null;
	}
}
