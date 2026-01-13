package com.day2.session1;

import javax.swing.text.AbstractDocument.BranchElement;

interface Jumpable {
	void jump();
}
//case 1
//class Kid extends Monkey{
//	public void jump() {
//		System.out.println("jumping from the wall hey monkey look me");
//	}
//	void study() {
//		System.out.println("study and run away");
//	}
//}

//case 2
//class Monkey implements Jumpable{
//	public void jump() {
//		System.out.println("jumping on tree");
//	}
//	void biteAGuys() {
//		System.out.println("bite someone");
//	}
//	
//	void stayOnTree() {
//		System.out.println("stay on tree");
//	}
//}
//
//class Kid implements Jumpable{
//	public void jump() {
//		System.out.println("jumping from the wall hey monkey look me");
//	}
//	void study() {
//		System.out.println("study and run away");
//	}
//}

//interface Flyable{
//	public void fly();
//}
//interface Swimmable{
//	public void swim();
//}
//abstract class Bird{
//	void eat() {
//		System.out.println("eat");
//	}
//}
//class Eagle extends Bird implements Flyable{
//	public void fly() {
//		System.out.println("flying like anything");
//	}
//	void eat() {
//		System.out.println("eat");
//	}
//}
//
//class Duck extends Bird implements Swimmable{
//	
//	public void swim() {
//		System.out.println("swim like anything");
//	}
//	void eat() {
//		System.out.println("eat");
//	}
//}
//
//class Emu extends Bird{
//	
//	void eat() {
//		System.out.println("eat slow eat");
//	}
//}

interface Flyable {
	public void fly();
}

interface Swimmable {
	public void swim();
}

class FastFlyable implements Flyable {

	@Override
	public void fly() {
		System.out.println("fly like anything");
	}

}

class SlowSwimmer implements Swimmable {
	@Override
	public void swim() {
		System.out.println("slow swim :(");
	}

}

class FastSwimmer implements Swimmable {
	@Override
	public void swim() {
		System.out.println("fast swim :)");
	}

}

class NoSwimmer implements Swimmable {
	@Override
	public void swim() {
		System.out.println("no swimming bhai");
	}

}

class Bird {
	private Flyable flyable;
	private Swimmable swimmable;

	Bird() {
		this.flyable = new FastFlyable();// give default behaviour
		this.swimmable = new FastSwimmer();
	}
	
	public void setFlyable(Flyable flyable) {
		this.flyable = flyable;
	}

	public void setSwimmable(Swimmable swimmable) {
		this.swimmable = swimmable;
	}


	void performFly() {
		flyable.fly();
	}
	void performSwim() {
		swimmable.swim();
	}
	void eat() {
		System.out.println("eat");
	}
}

public class DemoWhyHellWeNeedInterface {

	public static void main(String[] args) {
			Bird bird=new Bird();
			
			bird.performSwim();
			bird.performFly();
			bird.eat();
	}

}
