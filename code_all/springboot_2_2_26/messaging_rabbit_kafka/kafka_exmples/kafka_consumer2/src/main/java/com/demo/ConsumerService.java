package com.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.demo.dto.Order;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConsumerService {
	
	@KafkaListener(topics = "mynewtopic", groupId = "my_topic_group_id")
	public void consumeP0(Object order) {
		//Order orderObject=(Order) order;
		
		log.info("message is consumed from partion 0 "+ order);
	}
	
	
}
