package  com.example.Learning_Spring.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String name;
    private double salaryBudget;
    private List<String> assignedProjects;  // List of project IDs

    // Getters and Setters

    public List<String> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<String> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(double salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public Employee(List<String> assignedProjects, String id, String name, double salaryBudget) {
        this.assignedProjects = assignedProjects;
        this.id = id;
        this.name = name;
        this.salaryBudget = salaryBudget;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "assignedProjects=" + assignedProjects +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salaryBudget=" + salaryBudget +
                '}';
    }
}
