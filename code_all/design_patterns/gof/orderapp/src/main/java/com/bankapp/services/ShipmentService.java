package com.bankapp.services;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bankapp.event.OrderConfirmationEvent;

@Service
public class ShipmentService {

	@EventListener
	@Async
	public void handlerOrder(OrderConfirmationEvent confirmationEvent) {
		System.out.println("shipment is started: "+ 
	 confirmationEvent.getOrderId()+" : "+Thread.currentThread().getName());
	}
}
