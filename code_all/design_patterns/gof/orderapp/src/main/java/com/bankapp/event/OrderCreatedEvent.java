package com.bankapp.event;

public class OrderCreatedEvent{
	private String orderId;
	public OrderCreatedEvent(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}
}
