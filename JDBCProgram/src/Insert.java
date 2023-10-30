
 //-----------------Without PreparedStatement-------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert
{
  public static void main(String a[])
   {
	  int eno;
	  String name,dept;
	  Scanner scanner =new Scanner(System.in);
	  
	  System.out.print("Enter emp no : ");
	  eno = scanner.nextInt();
	  System.out.print("Enter emp name : ");
	  name = scanner.next();
	  System.out.print("Enter emp dept : ");
	  dept = scanner.next();
	  
	  try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 System.out.println("Driver Loaded.....");
	 
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","9572@Ssss");
	 System.out.println("Connection EStablished....");
	 
	 String sql ="insert into emp1 values("+eno+",'"+name+"','"+dept+"')";
	 Statement statement = connection.createStatement();
	 statement.executeUpdate(sql);
	 System.out.println("Table inserted...");
	 
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