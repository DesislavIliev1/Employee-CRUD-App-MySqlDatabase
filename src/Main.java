import service.DbEmployeeService;
import service.DbTaskService;
import service.EmployeeService;
import service.TaskService;

import java.sql.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        EmployeeService service = new EmployeeService();
        TaskService taskService = new TaskService();
        DbTaskService dbTaskService = new DbTaskService();
        DbEmployeeService dbEmployeeService = new DbEmployeeService();
        Scanner scan = new Scanner(System.in);
        dbEmployeeService.DBconnection();
        dbTaskService.DBconnection();


       // tes.DBconnection();
       /* try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeapp", "root", "des20sislav10");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("fullName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        */
        int choice;
        System.out.println("****************** Welcome to Employee Management System ****************");
        System.out.println("1.Employee options");
        System.out.println("2.Task options");
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        switch (choice) {
            case 1: {
                do {
                    System.out.println("1.Add Employee");
                    System.out.println("2. View Employee");
                    System.out.println("3. Update Employee");
                    System.out.println("4. Delete Employee");
                    System.out.println("5. View All Employees");
                    System.out.println("6. View top 5 Employees with the most Tasks");
                    System.out.println("0. Exit");

                    System.out.println("Enter your choice: ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            //service.addEmployee();
                            try {
                                dbEmployeeService.create();
                              // tes.createEmp();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            dbEmployeeService.viewObj();
                            //service.viewEmployee();
                            break;
                        case 3:
                           // service.updateEmployee();
                            dbEmployeeService.update();
                            break;
                        case 4:
                            dbEmployeeService.delete();
                           // service.deleteEmployee();
                            break;
                        case 5:
                            System.out.println("View all employees");
                            dbEmployeeService.viewAll();
                            //service.viewAllEmployees();
                            break;
                        case 6:
                            dbEmployeeService.topEmployees();
                    }
                } while (choice != 0);
                break;

            }
            case 2:
                do {
                    System.out.println("1.Add Task");
                    System.out.println("2. View Task");
                    System.out.println("3. Update Task");
                    System.out.println("4. Delete Task");
                    System.out.println("5. View All Tasks");
                    System.out.println("0. Exit");

                    System.out.println("Enter your choice: ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            dbTaskService.create();
                            //taskService.addTask();
                            break;
                        case 2:
                            dbTaskService.viewObj();
                            //taskService.viewTask();
                            break;
                        case 3:
                            dbTaskService.update();
                            //taskService.updateTask();
                            break;
                        case 4:
                            dbTaskService.delete();
                            //taskService.deleteTask();
                            break;
                        case 5:
                            System.out.println("View all employees");
                            dbTaskService.viewAll();
                            //taskService.viewAllTasks();
                            break;
                    }
                } while (choice != 0);
                break;

        }
    }
}

