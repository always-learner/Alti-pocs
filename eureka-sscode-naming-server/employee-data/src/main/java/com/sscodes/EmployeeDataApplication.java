package com.sscodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDataApplication.class, args);
	}

}
