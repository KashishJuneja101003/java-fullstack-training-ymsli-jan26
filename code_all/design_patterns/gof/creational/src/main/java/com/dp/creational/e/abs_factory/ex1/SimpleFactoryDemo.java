package com.dp.creational.e.abs_factory.ex1;

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
class TransportFactory {
	public static Transport createTransport(String type) {
		Transport transport = null;
		if (type.equals("truck")) {
			transport = new Truck();
		} else if (type.equals("ship")) {
			transport = new Ship();
		}
		return transport;
	}
}

public class SimpleFactoryDemo {

	public static void main(String[] args) {
		Transport transport=TransportFactory.createTransport("truck");
		transport.deliver();
	}
}
