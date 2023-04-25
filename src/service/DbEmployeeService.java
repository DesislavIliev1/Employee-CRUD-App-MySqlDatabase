package service;

import entity.Employee;

import java.sql.*;
import java.util.Scanner;

public class DbEmployeeService implements  CRUD{
    Scanner scan = new Scanner(System.in);
    public static  Connection connection;

    public void DBconnection()throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("fullName"));
        }
    }

    @Override
    public void create() {
        try {
            String sql = "insert into employees (idemployees,fullName, email, phoneNumber, dateOfBirth, MonthlySalary) values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("Enter id: ");
            preparedStatement.setInt(1, scan.nextInt());
            System.out.print("Enter Full Name: ");
            preparedStatement.setString(2, scan.next());
            System.out.print("Enter Email: ");
            preparedStatement.setString(3, scan.next());
            System.out.print("Enter Phone Number: ");
            preparedStatement.setInt(4, scan.nextInt());
            System.out.print("Enter Date of Birth: ");
            preparedStatement.setString(5, scan.next());
            System.out.print("Enter Monthly Salary: ");
            preparedStatement.setInt(6, scan.nextInt());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record inserted successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
    }

    }

    @Override
    public void viewObj() {

        try {
            System.out.println("Enter name: ");
            String name = scan.next();
            String sql = "select * from employees where fullName ="+name;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("idemployees");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                int phone = resultSet.getInt("phoneNumber");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                int salary = resultSet.getInt("monthlySalary");
                System.out.println(id + " " + fullName + " " + email + " " + phone + " " + dateOfBirth + " " + salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete() {

    }

    @Override
    public void viewAll() {

    }

    @Override
    public void update() {

    }





}
