package service;

import entity.Employee;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    List<Employee> empSet = new ArrayList<Employee>();

    Employee emp1 = new Employee(1, "Desislav", "deso10@abv.bg", 9887787, "02-02-1999", 2000);
    Employee emp2 = new Employee(2, "Ivan", "Ivan0@abv.bg", 932487, "02-09-1999", 3000);
    Employee emp3 = new Employee(3, "Petur", "Petur0@abv.bg", 9868787, "02-10-2005", 4000);
    Employee emp4 = new Employee(4, "Stoqn", "Stoq0@abv.bg", 986737787, "10-02-2010", 8000);

    Scanner scan = new Scanner(System.in);
    DbEmployeeService dbEmployeeService;
    boolean found = false;

    String fullName;
    String email;
    int phoneNumber;
    String dateOfBirth;
    int monthlySalary;

    public EmployeeService() {
        empSet.add(emp1);
        empSet.add(emp2);
        empSet.add(emp3);
        empSet.add(emp4);
    }

    public void addEmployee() {

        System.out.println("Enter Employe ID: ");
        int id = scan.nextInt();
        System.out.print("Enter Full Name: ");
        String fullName = scan.next();
        System.out.print("Enter Email: ");
        String email = scan.next();
        System.out.print("Enter Phone Number: ");
        int phoneNumber = scan.nextInt();
        System.out.print("Enter Date of Birth: ");
        String dateOfBirth = scan.next();
        System.out.print("Enter Monthly Salary: ");
        int monthlySalary = scan.nextInt();
        Employee emp = new Employee(id, fullName, email, phoneNumber, dateOfBirth, monthlySalary);
        empSet.add(emp);
        //dbEmployeeService.createEmployee(emp);

        System.out.println("Employee successfully created!");


    }

    public void viewAllEmployees(){
        for(Employee employee: empSet){
            System.out.println(employee);
        }
    }

    public void viewEmployee(){

        System.out.println("Enter the name of Employee: ");
        String name = scan.next();
        for(Employee employee: empSet){
            if(name.equals(employee.getFullName())){
                System.out.println(employee);
                found = true;
            }
        }
        if(!found){
            System.out.println("No record found");
        }
    }

    public void deleteEmployee() {
        try {
            found = false;
            System.out.println("Enter Employee name: ");
            String name = scan.next();
            for (Employee employee : empSet) {
                if (name.equals(employee.getFullName())) {
                    empSet.remove(employee);
                    found = true;
                    System.out.println("Employee successfully removed");
                }
            }
            if (!found) {
                System.out.println("No record found");
            }
        } catch (ConcurrentModificationException e){
        };
    }

    public void updateEmployee(){
        found = false;
        System.out.println("Enter Employee name: ");
        String name = scan.next();
        for(Employee employee: empSet){
            if(name.equals(employee.getFullName())){
                found = true;
                System.out.println("Enter new Full Name: " );
                String fullName = scan.next();
                System.out.println("Enter new Email: " );
                String email = scan.next();
                System.out.println("Enter new Phone Number: " );
                int phoneNumber = scan.nextInt();
                System.out.println("Enter new Date of Birth: " );
                String dateOfBirth = scan.next();
                System.out.println("Enter new Monthly Salary:" );
                int monthlySalary = scan.nextInt();
                employee.setFullName(fullName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setDateOfBirth(dateOfBirth);
                employee.setMonthlySalary(monthlySalary);

            }
            if(found = false){
                System.out.println("No record found");
            }
        }





    }
}
