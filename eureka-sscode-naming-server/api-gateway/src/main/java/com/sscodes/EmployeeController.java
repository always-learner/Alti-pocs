package com.sscodes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeServiceCallerProxy callerProxy;

    @GetMapping(path = "/getAllEmployees")
    public List<Employee> getAllEmployee(){
        return callerProxy.getAllEmployee();
    }
}
