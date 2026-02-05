package com.orderapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderapp.dto.OrderStatus;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;
    
    private static final String TOPIC = "demo-topic2";

    public void sendOrder(OrderStatus orderStatus) throws JsonProcessingException {
        System.out.println(" Sending message to Kafka: " + orderStatus);
        kafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(orderStatus));
        System.out.println("order is send");
    }
}











