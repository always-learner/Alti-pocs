package com.sscodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.sscodes")
@EnableDiscoveryClient
public class ValidationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationServiceApplication.class, args);
	}

}
