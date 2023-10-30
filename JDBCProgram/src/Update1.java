
 //-----------------With PreparedStatement-------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update1
{
  public static void main(String a[])
   {
	  int eno,sal;
	  String name,dept;
	  Scanner scanner =new Scanner(System.in);
	  
	  System.out.print("Enter emp no : ");
	  eno = scanner.nextInt();
	  System.out.print("Enter emp salary : ");
	  sal = scanner.nextInt();
	  
	  try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","9572@Ssss");
	
	 
	 String sql ="UPDATE emp1 SET Salary=? where eno=?";
	 PreparedStatement pstatement = connection.prepareStatement(sql);
	 
	 pstatement.setInt(1,eno);
	 pstatement.setInt(2,sal);
	 
	 pstatement.executeUpdate();
	 System.out.println("Record Updated...");
	 
	 
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