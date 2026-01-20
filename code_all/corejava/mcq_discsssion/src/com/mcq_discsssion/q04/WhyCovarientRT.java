package com.mcq_discsssion.q04;

//Rupa -->
//Milk PMilk
//class Milk {
//
//}
//
//class PMilk extends Milk {
//}
//
//class KD {
//	public PMilk getMilk(double money) {
//		return new PMilk();
//	}
//}
//
//class ImprovedKD extends KD {
//	@Override
//	public Object getMilk(double money) {
//		return new Milk();
//	}
//}
//IS-A vs Can-DO
 class Animal{
	  public void petBehaviour() {}
}
class Dog extends Animal{
	@Override
	public void petBehaviour() {
		System.out.println("bho bho pick me");
	}
	public void nighWtchManShip() {
		System.out.println("jagte raho");
	}
	
}
class Cat extends Animal{
	@Override
	public void petBehaviour() {
		System.out.println("m pick me");
	}
	
}

public class WhyCovarientRT {
	public static void main(String[] args) {
//		Dog animal=new Animal();
//		animal.nighWtchManShip();
		
	}

}
