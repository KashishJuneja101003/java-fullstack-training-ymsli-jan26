package com.dp.creational.e.abs_factory.ex3;
//Product A: Transport
interface Transport {
	void deliver();
}

//Product B: Packaging
interface Packaging {
 void pack();
}

// Concrete Products that A
class Truck implements Transport {
	public void deliver() {
		System.out.println("Deliver by land using a truck");
	}
}
class CardboardBox implements Packaging {
    public void pack() {
        System.out.println("Packing with cardboard box.");
    }
}

class Ship implements Transport {
	public void deliver() {
		System.out.println("Deliver by see using a ship");
	}
}
class ContainerBox implements Packaging {
    public void pack() {
        System.out.println("Packing with container box.");
    }
}
//Abs factory
interface LogisticsFactory {
    Transport createTransport();
    Packaging createPackaging();
}

class RoadLogisticsFactory implements LogisticsFactory{
	@Override
	public Transport createTransport() {
		return new Truck();
	}

	@Override
	public Packaging createPackaging() {
		return new CardboardBox();
	}	
}

class SeaLogisticsFactory implements LogisticsFactory{
	@Override
	public Transport createTransport() {
		return new Ship();
	}

	@Override
	public Packaging createPackaging() {
		return new ContainerBox();
	}	
}

class AbstractFactory{
	private Transport transport;
	private Packaging packaging;
	public AbstractFactory(LogisticsFactory logisticsFactory) {
		this.transport=logisticsFactory.createTransport();
		this.packaging=logisticsFactory.createPackaging();
	}
	public void placeShipment() {
		packaging.pack();
		transport.deliver();
	}
	
}

public class AbsFactoryDesignPatternDemo {

	public static void main(String[] args) {
		AbstractFactory roadAbstractFactory=new AbstractFactory(new RoadLogisticsFactory());
		roadAbstractFactory.placeShipment();
		
	}
}
