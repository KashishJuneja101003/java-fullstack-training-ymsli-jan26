package com.oops.ex0;

//
/*
 * "A passanger named raj is using metro to travel from BTM to Banargatta"
 * 
 * what is abstraction?
	design principle of seprating interface from implementation 
	so that client only concern with interface
	
	iplementated by interface / abs class
	we just need to press ac remote 
 */
//3 ways : use a , has a(Compostion and agg) , is a (inheritance)
//favour Compostion over inheritance*

//abstract class Vehicle{
//	public abstract void move(String s, String d) ;
//}
//"abstract class and interface are two ways to achive abs in java"

class Car{
	public void move(String s, String d) {
		System.out.println("passanger is moving from "+ s + " to "+ d +" using car");
	}
}

//OCP*
class Passanger {
	private String name;

	public Passanger(String name) {
		this.name = name;
	}
	
	public void travel(String s, String d, Car car) {
		System.out.println("passnger named : "+ name);
		car.move(s, d);
	}
	
}
public class DemoLoseCoupling {

	public static void main(String[] args) {
		Car  car=new Car();
		Passanger passanger=new Passanger("raj");
		passanger.travel("BTM", "Banargatta", car);
		
	}
}
