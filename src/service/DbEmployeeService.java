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

      //  while (resultSet.next()) {
     //       System.out.println(resultSet.getString("fullName"));
     //   }
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
            System.out.println("Enter id: ");
            int number = Integer.parseInt(scan.nextLine());
            //String name = scan.next();
            String sql = "select * from employees where idemployees = "+number;
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

       try {
           String sql = "select * from employees ";
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()) {
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
    public void update() {
        try {

            System.out.println("Enter id: ");
            int number = Integer.parseInt(scan.nextLine());
            //String name = scan.next();
            String sql = "select * from employees where idemployees = " + number;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("What record do you want to update? ");
            System.out.println("1. fullName");
            System.out.println("2. Email");
            System.out.println("3. Phone number");
            System.out.println("4. Date of Birth");
            System.out.println("5.Monthly salary");

            int choice = Integer.parseInt(scan.nextLine());
            String sqlQuery = "update employees set ";

            switch (choice){
                case 1:
                    System.out.println("Enter new Name: ");
                    String newName = scan.next();
                    sqlQuery = sqlQuery + "fullName = ? where idemployees = "+number;
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1,newName);
                    int rows = preparedStatement.executeUpdate();
                    if(rows > 0){
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 2:
                    System.out.println("Enter new Email: ");
                    String newEmail = scan.next();
                    sqlQuery = sqlQuery + "email = ? where idemployees = "+number;
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
                    preparedStatement2.setString(1,newEmail);
                    int rows2 = preparedStatement2.executeUpdate();
                    if(rows2 > 0){
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 3:
                    System.out.println("Enter new Phone number: ");
                    int newPhone = scan.nextInt();
                    sqlQuery = sqlQuery + "phoneNumber = ? where idemployees = "+number;
                    PreparedStatement preparedStatement3 = connection.prepareStatement(sqlQuery);
                    preparedStatement3.setInt(1,newPhone);
                    int rows3 = preparedStatement3.executeUpdate();
                    if(rows3 > 0){
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 4:
                    System.out.println("Enter new Date of Birth: ");
                    String newDateOfBirth = scan.next();
                    sqlQuery = sqlQuery + "dateOfBirth = ? where idemployees = "+number;
                    PreparedStatement preparedStatement4 = connection.prepareStatement(sqlQuery);
                    preparedStatement4.setString(1,newDateOfBirth);
                    int rows4 = preparedStatement4.executeUpdate();
                    if(rows4 > 0){
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 5:
                    System.out.println("Enter new Salary: ");
                    int newSalary = scan.nextInt();
                    sqlQuery = sqlQuery + "monthlySalary = ? where idemployees = "+number;
                    PreparedStatement preparedStatement5 = connection.prepareStatement(sqlQuery);
                    preparedStatement5.setInt(1,newSalary);
                    int rows5 = preparedStatement5.executeUpdate();
                    if(rows5 > 0){
                        System.out.println("Record updated successfully");
                    }

            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }





}
