package com.example.Learning_Spring.service;

import com.example.Learning_Spring.models.Employee;
import com.example.Learning_Spring.models.Profit;
import com.example.Learning_Spring.models.Project;
import com.example.Learning_Spring.repo.EmployeeRepository;
import com.example.Learning_Spring.repo.ProfitReportRepository;
import com.example.Learning_Spring.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProfitReportRepository profitReportRepository;

    public  Mono<Project> createProject(Project project){
        return projectRepository.save(project);
    }

    public Mono<Employee> addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    // Assign an employee to a project
    public Mono<Project> assignEmployeeToProject(String projectId, Employee employee) {
        return projectRepository.findById(projectId)
                .flatMap(project -> {
                    double afterTaxBudget = project.getBudget() - (project.getBudget() * (project.getTax() / 100));
                    if (afterTaxBudget >= employee.getSalaryBudget()) {
                        project.getEmployeeIds().add(employee.getId());
                        employee.getAssignedProjects().add(projectId);
                        return Mono.zip(
                                projectRepository.save(project),
                                employeeRepository.save(employee)
                        ).thenReturn(project);
                    }
                    return Mono.error(new IllegalArgumentException("Not enough budget to assign employee."));
                });
    }

    // Generate profit report for a project
    public Mono<Profit> generateProfitReport(String projectId, int year) {
        return projectRepository.findById(projectId)
                .flatMap(project -> {
                    double afterTaxBudget = project.getBudget() - (project.getBudget() * (project.getTax() / 100));
                    double totalEmployeeSalary = 0;
                    for (String employeeId : project.getEmployeeIds()) {
                        totalEmployeeSalary += employeeRepository.findById(employeeId)
                                .map(Employee::getSalaryBudget)
                                .block();  // This can be improved with async handling
                    }

                    double companyProfit = afterTaxBudget - totalEmployeeSalary;
                    Profit profitReport = new Profit();
                    profitReport.setYear(year);
                    profitReport.setProjectId(projectId);
                    profitReport.setCompanyProfit(companyProfit);
                    profitReport.setTaxPaid(project.getBudget() * (project.getTax() / 100));

                    return profitReportRepository.save(profitReport);
                });
    }

    // Get profit reports by year
    public Flux<Profit> getProfitReportsByYear(int year) {
        return profitReportRepository.findByYear(year);
    }
}
