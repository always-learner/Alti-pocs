package com.sscodes;

import com.sscodes.kafka.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(KafkaProducerApplication.class, args);
		new KafkaProducerApplication().callProducer();
	}

	private void callProducer(){
		KafkaProducer kafkaProducer = new KafkaProducer();
		try {
			kafkaProducer.produceMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
