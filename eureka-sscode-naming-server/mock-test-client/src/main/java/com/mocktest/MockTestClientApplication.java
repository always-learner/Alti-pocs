package com.mocktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockTestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockTestClientApplication.class, args);
		HttpAndHttpsTest httpAndHttpsTest = new HttpAndHttpsTest();

		httpAndHttpsTest.httpTest();
		httpAndHttpsTest.httpsTest();
	}

}
