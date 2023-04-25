import java.sql.*;
import java.util.Scanner;



public class test {

    Scanner scan = new Scanner(System.in);
    public static Connection connection;
    public static void main(String[] args) throws SQLException {
        test tes = new test();



        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("fullName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            tes.createEmp();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void DBconnection()throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("fullName"));
        }
    }

    public void createEmp()throws SQLException {

        String sql =  "insert into employees (idemployees,fullName, email, phoneNumber, dateOfBirth, MonthlySalary) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Enter id: ");
        preparedStatement.setInt(1, scan.nextInt());
        System.out.print("Enter Full Name: ");
        preparedStatement.setString(2,scan.next());
        System.out.print("Enter Email: ");
        preparedStatement.setString(3, scan.next());
        System.out.print("Enter Phone Number: ");
        preparedStatement.setInt(4, scan.nextInt());
        System.out.print("Enter Date of Birth: ");
        preparedStatement.setString(5,scan.next());
        System.out.print("Enter Monthly Salary: ");
        preparedStatement.setInt(6, scan.nextInt());

        int rows = preparedStatement.executeUpdate();
        if(rows>0){
            System.out.println("Record inserted successfully");
        }
    }
}
