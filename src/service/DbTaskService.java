package service;

import java.sql.*;
import java.util.Scanner;

public class DbTaskService implements  CRUD{

    public static  Connection connection;
    Scanner scan = new Scanner(System.in);


    public void DBconnection()throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employees");
    }

    @Override
    public void create() {
        try {

            String sql = "insert into tasks (idTask, title, description, due_date, employee_id ) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("Enter id: ");
            preparedStatement.setInt(1, scan.nextInt());
            System.out.print("Enter Title: ");
            preparedStatement.setString(2, scan.next());
            System.out.print("Enter description: ");
            scan.nextLine();
            preparedStatement.setString(3, scan.nextLine());
            System.out.print("Enter due date: ");
            preparedStatement.setString(4, scan.next());
            System.out.print("Enter employee id : ");
            preparedStatement.setInt(5, scan.nextInt());


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
            System.out.println("Enter task id: ");
            int number = scan.nextInt();
            String sql = "Select * from tasks where idTask =" + number;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("idTask");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String dueDate = resultSet.getString("due_date");
                int emp_id = resultSet.getInt("employee_id");
                System.out.println(id + " " + title + " " + description + " " + dueDate + " " + emp_id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete() {
        try {
            System.out.println("Enter task id to delete it: ");
            int number = scan.nextInt();
            String sql = "Delete from tasks where idTask = " + number;
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0){
                System.out.println("Task successfully deleted");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void viewAll() {
        try {
            String sql = "Select * from tasks";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("idTask");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String dueDate = resultSet.getString("due_date");
                int employeeId = resultSet.getInt("employee_id");
                System.out.println(id + " " + title + " " + description + " " + dueDate + " " + employeeId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {
        try {
            System.out.println("Enter task id to update: ");
            int id = scan.nextInt();
            String sql = "Select * from tasks where idTask =" + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("What record do you want to update? ");
            System.out.println("1. Title");
            System.out.println("2. Description");
            System.out.println("3. Due date");
            System.out.println("4. Employee id");

            int choice = scan.nextInt();
            String sqlQuery = "update tasks set ";

            switch (choice) {
                case 1:
                    System.out.println("Enter new Title: ");
                    String newTitle = scan.next();
                    sqlQuery = sqlQuery + "title = ? where idTask = " + id;
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, newTitle);
                    int rows = preparedStatement.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 2:
                    System.out.println("Enter new Description: ");
                    String newDesc = scan.next();
                    sqlQuery = sqlQuery + "description = ? where idTask = " + id;
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
                    preparedStatement2.setString(1, newDesc);
                    int rows2 = preparedStatement2.executeUpdate();
                    if (rows2 > 0) {
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 3:
                    System.out.println("Enter new Due date: ");
                    String newDueDate = scan.next();
                    sqlQuery = sqlQuery + "due_date = ? where idTask = " + id;
                    PreparedStatement preparedStatement3 = connection.prepareStatement(sqlQuery);
                    preparedStatement3.setString(1, newDueDate);
                    int rows3 = preparedStatement3.executeUpdate();
                    if (rows3 > 0) {
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 4:
                    System.out.println("Enter new Employee id: ");
                    int newEmpId = scan.nextInt();
                    sqlQuery = sqlQuery + "employee_id = ? where idTask = " + id;
                    PreparedStatement preparedStatement4 = connection.prepareStatement(sqlQuery);
                    preparedStatement4.setInt(1, newEmpId);
                    int rows4 = preparedStatement4.executeUpdate();
                    if (rows4 > 0) {
                        System.out.println("Record updated successfully");
                    }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
