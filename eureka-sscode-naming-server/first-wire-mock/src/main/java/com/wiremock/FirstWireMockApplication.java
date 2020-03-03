package com.wiremock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FirstWireMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWireMockApplication.class, args);

		final String uri = "https://localhost:8081/one";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
	}

}
