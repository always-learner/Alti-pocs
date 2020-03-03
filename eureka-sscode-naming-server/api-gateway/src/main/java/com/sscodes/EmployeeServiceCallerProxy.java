package com.sscodes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8011")
public interface EmployeeServiceCallerProxy {

    @GetMapping(path = "/getAllEmployees")
    List<Employee> getAllEmployee();
}
