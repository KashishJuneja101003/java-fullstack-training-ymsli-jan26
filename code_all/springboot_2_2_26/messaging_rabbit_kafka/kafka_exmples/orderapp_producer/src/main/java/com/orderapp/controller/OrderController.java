package com.orderapp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.dto.Order;
import com.orderapp.dto.OrderStatus;
import com.orderapp.service.OrderProducerService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducerService producerService;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS",
                "Order placed successfully at " + restaurantName);
        producerService.sendOrder(orderStatus);
        return "✅ Order sent to Kafka successfully!";
    }
}