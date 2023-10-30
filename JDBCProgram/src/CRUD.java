import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {
    Connection connection;
    PreparedStatement preparedstatement;
    Statement statement;
    ResultSet resultset;

    String ename, dept, sql;
    Integer eno, salary;
    static Scanner scanner = new Scanner(System.in);

    public CRUD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "9572@Ssss");
    }

    public void addRecord() throws SQLException {
        System.out.print("Enter emp no : ");
        eno = scanner.nextInt();
        System.out.print("Enter emp name : ");
        ename = scanner.next();
        System.out.print("Enter dept : ");
        dept = scanner.next();
        System.out.print("Enter salary : ");
        salary = scanner.nextInt();

        sql = "insert into emp1(eno, ename, dept, salary) values(?, ?, ?, ?)";
        preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setInt(1, eno);
        preparedstatement.setString(2, ename);
        preparedstatement.setString(3, dept);
        preparedstatement.setInt(4, salary);
        preparedstatement.executeUpdate();

        System.out.println("Record added...");
    }

    public void deleteRecord() throws SQLException {
        System.out.print("Enter emp no : ");
        eno = scanner.nextInt();

        sql = "delete from emp1 where eno = ?";
        preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setInt(1, eno);
        if (preparedstatement.executeUpdate() > 0) {
            System.out.println("Record deleted...");
        } else {
            System.out.println("Emp does not exist...");
        }
    }

    public void updateRecord() throws SQLException {
        System.out.print("Enter emp no : ");
        eno = scanner.nextInt();
        System.out.print("Enter salary : ");
        salary = scanner.nextInt();

        sql = "update emp1 set salary = ? where eno = ?";
        preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setInt(1, salary);
        preparedstatement.setInt(2, eno);
        if (preparedstatement.executeUpdate() > 0) {
            System.out.println("Record updated...");
        } else {
            System.out.println("Emp does not exist...");
        }
    }

    public void findRecordById() throws SQLException {
        System.out.print("Enter emp no : ");
        eno = scanner.nextInt();

        sql = "select * from emp1 where eno = ?";
        preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setInt(1, eno);
        resultset = preparedstatement.executeQuery();
        if (resultset.next()) {
            System.out.println("Eno\tName\tDept\tSalary");
            System.out.println("-------------------------");
            System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3) + "\t" + resultset.getInt(4));
        } else {
            System.out.println("Emp does not exist...");
        }
    }

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("-----Employee Operation-----");
        System.out.println("----------------------------");
        System.out.println("1. Add Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Update Record");
        System.out.println("4. Find Record By EmpId");
        System.out.println("5. Exit Application");

        while (choice != 5) {
            System.out.println("Enter Operation No :");
            choice = scanner.nextInt();
            try {
                CRUD crud = new CRUD();
                switch (choice) {
                    case 1:
                        crud.addRecord();
                        break;
                    case 2:
                        crud.deleteRecord();
                        break;
                    case 3:
                        crud.updateRecord();
                        break;
                    case 4:
                        crud.findRecordById();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Operation. Try Again");
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
