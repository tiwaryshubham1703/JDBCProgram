import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select 
{
    public static void main(String a[]) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "9572@Ssss");

            String sql = "select * from emp1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Eno  Name        Dept        Salary");
            System.out.println("------------------------------------");

            while (resultSet.next())
            {
                int eno = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String dept = resultSet.getString(3);
                int salary = resultSet.getInt(4);

                System.out.printf("%-4d %-12s %-12s %d%n", eno, name, dept, salary);
            }

            connection.close();
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
}
