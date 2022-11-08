package com.employee.service.employeeservice.service;

import com.employee.service.employeeservice.model.Employee;
import com.employee.service.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;


    public ResponseEntity<Employee> addEmployee(Employee employee){
        try{
//            Employee tempEmployee = repository.save(new Employee(UUID.randomUUID(),
//                    employee.getName(),
//                    employee.getEmail(),
//                    employee.getState())
//            );
            Employee tempEmployee = repository.save(employee);
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public String deleteEmployee(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Successfully Deleted Employee with id :"+id;
        }
        return "Employee Not Found!!";
    }
}