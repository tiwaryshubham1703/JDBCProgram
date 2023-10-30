 //-----------------Without PreparedStatement-------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create 
{
  public static void main(String a[])
   {
	  try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 System.out.println("Driver Loaded.....");
	 
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","9572@Ssss");
	 System.out.println("Connection EStablished....");
	 
	 String sql ="create table emp1(eno int,ename varchar(20))";
	 Statement statement = connection.createStatement();
	 statement.executeUpdate(sql);
	 System.out.println("Table created...");
	 
	 connection.close();
     }
	  catch(ClassNotFoundException e)
	  {
		  System.out.println(e);
	  }
	  catch(SQLException e)
	  {
		  System.out.println(e);
	  }
   }
}