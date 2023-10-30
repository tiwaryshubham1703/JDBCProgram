
 //-----------------With PreparedStatement-------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert1
{
  public static void main(String a[])
   {
	  int eno,sal;
	  String name,dept;
	  Scanner scanner =new Scanner(System.in);
	  
	  System.out.print("Enter emp no : ");
	  eno = scanner.nextInt();
	  System.out.print("Enter emp name : ");
	  name = scanner.next();
	  System.out.print("Enter emp dept : ");
	  dept = scanner.next();
	  System.out.print("Enter emp salary : ");
	  sal = scanner.nextInt();
	  
	  try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","9572@Ssss");
	
	 
	 String sql ="insert into emp1 values(?,?,?,?)";
	 PreparedStatement pstatement = connection.prepareStatement(sql);
	 pstatement.setInt(1,eno);
	 pstatement.setString(2,name);
	 pstatement.setString(3,dept);
	 pstatement.setInt(4,sal);
	 
	 pstatement.executeUpdate();
	 System.out.println("Record added...");
	 connection.close();
	 
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