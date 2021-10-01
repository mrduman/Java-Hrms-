package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/getAll")
    public List<Employee> getAll(){

        return this.employeeService.getAll();
    }
}
