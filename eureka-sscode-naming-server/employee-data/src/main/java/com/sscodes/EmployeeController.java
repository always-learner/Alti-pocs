package com.sscodes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmployeeData(){
        return "Returning employee data ";
    }
}
