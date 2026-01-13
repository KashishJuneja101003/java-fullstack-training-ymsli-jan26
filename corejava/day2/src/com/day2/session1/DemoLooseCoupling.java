package com.day2.session1;

/*
 * loose coupling and high cohesion
a passanger named raj is moving from LN to Noida using Metro
 */

//abstract class Vehical {
//	 abstract public void move(String source, String destination) ;
//}
//interface was 100% abstraction till java 7
interface Vehical {
	  public void move(String source, String destination) ;
}

class Metro implements Vehical{
	public void move(String source, String destination) {
		System.out.println("moving from " + source + " to " + destination+" using metro");
	}
}
class Bike  implements Vehical {
	public void move(String source, String destination) {
		System.out.println("moving from " + source + " to " + destination+" using bike");
	}
}

class Passanger {

	private String name;

	public void travel(Vehical vehical, String source, String destination) {
		System.out.println("name of passanger: " + getName());
		vehical.move(source, destination);
	}

	public Passanger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

public class DemoLooseCoupling {

	public static void main(String args[]) {
//		Vehical vehical=new Metro();
//		
//		vehical.move("LN", "Noida");
		
		
		Metro metro = new Metro();
		Passanger passanger = new Passanger("raj");
		passanger.travel(metro, "LN", "Noida");

	}
}
