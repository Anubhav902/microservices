package com.employee.service.employeeservice.controller;

import com.employee.service.employeeservice.model.Employee;
import com.employee.service.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }


    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }


    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }


    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }

}
