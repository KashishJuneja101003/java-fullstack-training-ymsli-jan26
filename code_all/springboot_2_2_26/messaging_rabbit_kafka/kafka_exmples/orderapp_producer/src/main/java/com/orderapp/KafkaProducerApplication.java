package com.orderapp;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.serializer.JsonSerializer;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}
