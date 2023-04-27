package service;

import entity.Task;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class TaskService {
    Scanner scan = new Scanner(System.in);
    boolean found = false;

    List<Task> tasks = new ArrayList<Task>();

    Task task1 = new Task("chemistry", "make a new element",  "03-05-2023");
    Task task2 = new Task("biology", "make a  ..",  "10-05-2023");
    Task task3 = new Task("maths", "make a new exercise",  "15-05-2023");
    Task task4 = new Task("english", "make a new sentence",  "12-05-2023");

    public TaskService() {
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

    }

    public void addTask() {
        System.out.print("Enter Task Title: ");
        String title = scan.next();
        System.out.print("Enter Description: ");
        String description = scan.next();
        System.out.print("Enter Assignee: ");
        String assignee = scan.next();
        System.out.print("Enter Due Date: ");
        String dueDate = scan.next();

        tasks.add(new Task(title, description,  dueDate));
        System.out.println("Task successfully created!");
    }

    public void viewAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void viewTask() {
        System.out.println("Enter the title of Task: ");
        String title = scan.next();
        for (Task task : tasks) {
            if (title.equals(task.getTitle())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No record found");
        }
    }

    public void deleteTask() {
        try {
            System.out.println("Enter task title: ");
            String name = scan.nextLine();
            for (Task task : tasks) {
                if (name.equals(task.getTitle())) {
                    tasks.remove(task);
                    System.out.println("Task successfully removed");

                }
            }

        } catch (ConcurrentModificationException e) {
        }
        ;
    }

    public void updateTask() {
        System.out.println("Enter task title: ");
        String title = scan.nextLine();
        for (Task task : tasks) {
            if (title.equals(task.getTitle())) {
                System.out.println("Enter new task title: ");
                String newTitle = scan.next();
                System.out.println("Enter new task description: ");
                String newDescr = scan.next();
                System.out.println("Enter new task assignee: ");
                String newAssignee = scan.next();
                System.out.println("Enter new task due date: ");
                String newDueDate = scan.next();
                task.setTitle(newTitle);
                task.setDescription(newDescr);
                task.setDueDate(newDueDate);
            } else {
                System.out.println("No record found!");
            }
        }

    }
}
