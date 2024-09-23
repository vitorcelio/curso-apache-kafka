package com.consumer.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ConsumerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerKafkaApplication.class, args);
	}

}
