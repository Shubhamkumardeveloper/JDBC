package connectionPool;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class TestApple {
	public static void main(String[] args) {
		Connection con=ConnectionPool.getConnectionObject();
		String sql="INSERT INTO product VALUES(104,'book','solid','to write','yes',40)";
		
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			ConnectionPool.receiveConnectionObject(con);
			System.out.println("Data inserted..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
