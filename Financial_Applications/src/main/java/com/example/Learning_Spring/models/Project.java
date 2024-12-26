package  com.example.Learning_Spring.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
public class Project{

    @Id
    private String id;
    private String name;
    private double budget;
    private double tax;  // percentage (e.g., 10%)
    private List<String> employeeIds;  // List of assigned employee IDs
    private int year;

    // Getters and Setters

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<String> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<String> employeeIds) {
        this.employeeIds = employeeIds;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Project(double budget, List<String> employeeIds, String id, double tax, String name, int year) {
        this.budget = budget;
        this.employeeIds = employeeIds;
        this.id = id;
        this.tax = tax;
        this.name = name;
        this.year = year;
    }

    public Project() {
    }
}
