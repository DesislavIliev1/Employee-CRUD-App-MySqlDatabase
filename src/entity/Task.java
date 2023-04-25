package entity;

import java.util.HashSet;
import java.util.Set;

public class Task {
    private String title;
    private String description;
    private String assignee;
    private String dueDate;
    private Set<Employee> employees = new HashSet<Employee>();

    public Task(String title, String description, String assignee, String dueDate) {
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return  title + '\'' + description + '\'' +
                assignee + '\'' +  dueDate ;
    }

}
