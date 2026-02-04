package com.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConsumerService {
	/*
	 * @KafkaListener(topics = "busycoder-demo", groupId = "my_topic_group_id", topicPartitions
		= {@TopicPartition(topic = "busycoder-demo", partitions = {"2"})})
	 */
	@KafkaListener(topics = "mynewtopic", groupId = "my_topic_group_id",
			topicPartitions= {@TopicPartition(topic = "mynewtopic", partitions = {"0"})})
	public void consumeP0(String message) {
		log.info("message is consumed from partion 0 "+ message);
	}
	
	@KafkaListener(topics = "mynewtopic", groupId = "my_topic_group_id",
			topicPartitions= {@TopicPartition(topic = "mynewtopic", partitions = {"1"})})
	public void consumeP1(String message) {
		log.info("message is consumed from partion 1 "+ message);
	}
	@KafkaListener(topics = "mynewtopic", groupId = "my_topic_group_id",
			topicPartitions= {@TopicPartition(topic = "mynewtopic", partitions = {"2"})})
	public void consumeP2(String message) {
		log.info("message is consumed from partion 2 "+ message);
	}
	
}
