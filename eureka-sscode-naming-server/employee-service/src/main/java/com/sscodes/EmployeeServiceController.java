package com.sscodes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableSwagger2
@EnableDiscoveryClient
@Api(value = "Employee service controller ", description = "controller for employee transaction")
public class EmployeeServiceController {

    @ApiOperation(value = "Value for get all employees ", notes = "get all employees notes ")
    public List<Employee> getAllEmployee(){
        final List<Employee> employees = createEmployees();
        return employees;
    }

    private List<Employee> createEmployees(){
        final Employee employee = new Employee(1, "Employee 1", "department 1");
        final Employee employee1 = new Employee(1, "Employee 1", "department 1");
        final Employee employee2 = new Employee(1, "Employee 1", "department 1");
        return Arrays.asList(employee, employee1, employee2);
    }
}
