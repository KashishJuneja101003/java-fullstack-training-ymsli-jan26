package com.dp.creational.e.abs_factory.ex2;

interface Transport {
	void deliver();
}

// Concrete Products
class Truck implements Transport {
	public void deliver() {
		System.out.println("Deliver by land using a truck");
	}
}

class Ship implements Transport {
	public void deliver() {
		System.out.println("Deliver by see using a ship");
	}
}

//Simple Factory: OCP
/*
 * A Factory Method lets subclasses decide which object to create. The parent
 * defines a method, but child classes implement the actual creation logic.
 * 
 * In simple words: Each subclass has its own factory logic. The parent says, “I
 * need a product,” and the child decides which one exactly.
 */
abstract class Logistic {
	public void planDelivery() {
		Transport transport = createTransport();
		transport.deliver();
	}

	public abstract Transport createTransport();
}

class RoadLogistic extends Logistic {
	@Override
	public Transport createTransport() {
		return new Truck();
	}

}

class SeaLogistic extends Logistic {
	@Override
	public Transport createTransport() {
		return new Ship();
	}

}

public class FactoryMethodDesignPatternDemo {

	public static void main(String[] args) {
		Logistic logistic = new RoadLogistic();
		logistic.createTransport();
	}
}
