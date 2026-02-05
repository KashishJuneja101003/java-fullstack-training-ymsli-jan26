package com.orderapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.orderapp.dto.OrderStatus;

@Service
public class OrderConsumerService {

    @KafkaListener(topics = "demo-topic", groupId = "order_group_id")
    public void consumeOrder(OrderStatus orderStatus) {
        System.out.println(" Message received from Kafka: " + orderStatus);
    }
}