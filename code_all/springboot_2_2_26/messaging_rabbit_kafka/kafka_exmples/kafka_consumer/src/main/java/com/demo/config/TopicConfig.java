package com.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

	@Bean
	public NewTopic newTopic() {
		//public NewTopic(String name, int numPartitions, short replicationFactor)
		return new NewTopic("mynewtopic", 3, (short)1);
	}
}
