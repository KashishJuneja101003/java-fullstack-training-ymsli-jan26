package com.orderapp.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.orderapp.dto.OrderStatus;

@Service
public class OrderProducerService {

    @Autowired
    private KafkaTemplate<String, OrderStatus> kafkaTemplate;

    private static final String TOPIC = "demo-topic2";

    public void sendOrder(OrderStatus orderStatus) {
        System.out.println(" Sending message to Kafka: " + orderStatus);
        kafkaTemplate.send(TOPIC, orderStatus);
        System.out.println("order is send");
    }
}