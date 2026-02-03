package com.dp.behavioural.c.strategy_dp;

import java.util.ArrayList;
import java.util.List;

//Strategy Interface
interface PaymentStrategy {
	void pay(int amount);
}

//Concrete Strategies
class PayPalStrategy implements PaymentStrategy {
	private String email;

	public PayPalStrategy(String email) {
		this.email = email;
	}

	public void pay(int amount) {
		System.out.println("Paid ₹" + amount + " using PayPal (" + email + ")");
	}
}

class CreditCardStrategy implements PaymentStrategy {
	private String email;

	public CreditCardStrategy(String email) {
		this.email = email;
	}

	public void pay(int amount) {
		System.out.println("Paid ₹" + amount + " using CreditCard (" + email + ")");
	}
}

class CodStrategy implements PaymentStrategy {
	private String email;

	public CodStrategy(String email) {
		this.email = email;
	}

	public void pay(int amount) {
		System.out.println("Paid ₹" + amount + " using COD (" + email + ")");
	}
}

//Context – ShoppingCart
//SOLID
class ShoppingCart {
	private List<Integer> items = new ArrayList<>();

	public void addItem(int price) {
		items.add(price);
	}
	
	//
	
	public void pay(PaymentStrategy paymentStrategy) {
		int totol = items.stream().mapToInt(Integer:: intValue).sum();
		paymentStrategy.pay(totol);
	}
}

public class Main {

	public static void main(String[] args) {
		ShoppingCart cart=new ShoppingCart();
		cart.addItem(12);
		cart.addItem(2);
		cart.addItem(192);
		cart.addItem(9029);
		
		cart.pay(new CreditCardStrategy("r@gmail.com"));
		
	}
}
