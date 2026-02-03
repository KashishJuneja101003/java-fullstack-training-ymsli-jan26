package com.bankapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.services.OrderService;

@RestController
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping(path = "orders")
	public String bookOrder() {
		orderService.createOrder();
		return "order is placed";
	}
}
