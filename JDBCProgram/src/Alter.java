import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Alter
{
  public static void main(String a[])
   {
	  try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 System.out.println("Driver Loaded.....");
	 
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","9572@Ssss");
	 System.out.println("Connection EStablished....");
	 
	 String sql ="alter table emp1 add dept varchar(10) not null";
	 Statement statement = connection.createStatement();
	 statement.executeUpdate(sql);
	 System.out.println("Table altered...");
	 
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