package com.bankapp.services;

import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.bankapp.event.OrderCreatedEvent;

@Service
public class OrderService {

	private ApplicationEventPublisher applicationEventPublisher;

	public OrderService(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void createOrder() {
		String orderId = UUID.randomUUID().toString();

		System.out.println("order is created: " + orderId+" : "+ Thread.currentThread().getName());
		applicationEventPublisher.publishEvent(new OrderCreatedEvent(orderId));

	}
}
