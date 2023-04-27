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

    }
}
