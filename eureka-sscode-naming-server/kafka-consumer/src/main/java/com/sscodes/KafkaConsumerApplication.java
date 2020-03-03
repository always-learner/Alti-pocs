package com.sscodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {

	private KafkaClientConsumer clientConsumer = new KafkaClientConsumer();

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
		new KafkaConsumerApplication().callMessageConsumer();
	}

	private void callMessageConsumer(){
		clientConsumer.ConsumeMessage();
	}

}
