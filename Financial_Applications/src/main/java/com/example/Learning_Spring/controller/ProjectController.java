package com.example.Learning_Spring.controller;
import com.example.Learning_Spring.models.Employee;
import com.example.Learning_Spring.models.Profit;
import com.example.Learning_Spring.models.Project;
import com.example.Learning_Spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/org")
public class ProjectController {

    @Autowired
    private ProjectService projectService;



    // Create a new project
    @PostMapping("/addProject")
    public Mono<Project> createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // Assign employee to project
    @PostMapping("/{projectId}/assign")
    public Mono<Project> assignEmployeeToProject(
            @PathVariable String projectId,
            @RequestBody Employee employee
    ) {
        return projectService.assignEmployeeToProject(projectId, employee);
    }

    // Generate profit report for project
    @PostMapping("/{projectId}/report/{year}")
    public Mono<Profit> generateProfitReport(
            @PathVariable String projectId,
            @PathVariable int year
    ) {
        return projectService.generateProfitReport(projectId, year);
    }

    // Get profit reports for a given year
    @GetMapping("/report/year/{year}")
    public Flux<Profit> getProfitReportsByYear(@PathVariable int year) {
        return projectService.getProfitReportsByYear(year);
    }
    @PostMapping("/addEmployee")
    public  Mono<Employee> addEmployee(@RequestBody Employee employee){
        return projectService.addEmployee(employee);
    }
}
