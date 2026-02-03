package com.bankapp.services;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bankapp.event.OrderConfirmationEvent;
import com.bankapp.event.OrderCreatedEvent;

@Service
public class ConfigrmationService {
	private ApplicationEventPublisher applicationEventPublisher;

	public ConfigrmationService(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	@EventListener
	@Async
	public void confirmOrder(OrderCreatedEvent createdEvent) {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		System.out.println("sending confirmation for this order :"+
		createdEvent.getOrderId()+" : "+Thread.currentThread().getName());
		
		applicationEventPublisher.publishEvent(new OrderConfirmationEvent(createdEvent.getOrderId()));
	}

}
