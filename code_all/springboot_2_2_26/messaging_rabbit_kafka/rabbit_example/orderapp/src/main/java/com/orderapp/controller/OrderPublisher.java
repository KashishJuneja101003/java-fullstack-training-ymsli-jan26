package com.orderapp.controller;

import com.orderapp.config.RabbitMQConfig;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderPublisher {

    @Autowired
    public RabbitTemplate rabbitTemplate;


    @PostMapping("{restName}")
    public String bookOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());
        OrderResponse response=OrderResponse.builder()
                .order(order).message("order is booked").status("PENDING")
                .build();

        rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_EXCHANGE, RabbitMQConfig.ORDER_ROUTINGKEY, response);

        return "order is booked";
    }

}


















