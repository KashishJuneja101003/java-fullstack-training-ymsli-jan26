package com.demo2;
//OO design : seprate what varies
//Strategy design pattern

interface Swimmable{
	void swimm() ;
}
class NoSwimming implements Swimmable{
	@Override
	public void swimm() {
		System.out.println("no swimming");
	}
}
class GoodSwimming implements Swimmable{
	@Override
	public void swimm() {
		System.out.println("good swimming");
	}
}

interface Flyable{
	void fly() ;
}

class NoFly implements Flyable{
	@Override
	public void fly() {
		System.out.println("no fly");
	}
}

class GoodFly implements Flyable{
	@Override
	public void fly() {
		System.out.println("good fly");
	}
}


class Bird {
	private Flyable flyable;
	private Swimmable swimmable;
	
	public void setFlyable(Flyable flyable) {
		this.flyable = flyable;
	}
	public void setSwimmable(Swimmable swimmable) {
		this.swimmable = swimmable;
	}
	void sound() {
		System.out.println("bird sound");
	}
	public void printDetails() {
		sound();
		flyable.fly();
		swimmable.swimm();
	}
}


//
//class Eagle extends Bird implements Flyable {
//
//	@Override
//	public void fly() {
//		System.out.println("fly like anything");
//	}
//}
//
//class Emu extends Bird {
//}
//
//class Duck extends Bird implements Swimmable{
//
//	@Override
//	public void swimm() {
//		System.out.println("i am good in swimming");
//	}
//}

public class DemoNeedOfInterface {

	public static void main(String[] args) {
		Bird eagle=new Bird();
		eagle.setFlyable(new GoodFly());
		eagle.setSwimmable(new NoSwimming());
		eagle.printDetails();
	}
}
