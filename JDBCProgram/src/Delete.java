
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    public static void main(String a[]) {
        int eno;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter emp no : ");
        eno = scanner.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.....");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "9572@Ssss");
            System.out.println("Connection Established....");

            String sql = "DELETE FROM emp1 WHERE eno = " + eno;
            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Record deleted...");
            } else {
                System.out.println("No record found for emp no: " + eno);
            }

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
