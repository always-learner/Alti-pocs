package com.servicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.servicedemo"})
public class ServicedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicedemoApplication.class, args);
	}

}
