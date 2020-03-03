package com.sscodes.services;

import com.sscodes.model.Employee;
import com.sscodes.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(final long employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void createEmployee(final Employee employee) throws Exception {
        employeeRepository.save(employee);
        throw  new Exception("Test");
    }

    public void deleteEmployeeById(final Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public void deleteEmployee(final Employee employee){
        employeeRepository.delete(employee);
    }
}
