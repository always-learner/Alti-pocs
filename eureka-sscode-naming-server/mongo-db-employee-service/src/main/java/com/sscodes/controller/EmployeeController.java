package com.sscodes.controller;

import com.sscodes.model.Employee;
import com.sscodes.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable final Long employeeId){
        final Optional<Employee> employeeById = employeeService.getEmployeeById(employeeId);
        return employeeById.get();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    @Transactional
    public void createEmployee(@RequestBody final Employee employee) throws Exception {
        employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable final Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @DeleteMapping("/employees")
    public  void deleteEmployee(@RequestBody final Employee employee){
        employeeService.deleteEmployee(employee);
    }
}
