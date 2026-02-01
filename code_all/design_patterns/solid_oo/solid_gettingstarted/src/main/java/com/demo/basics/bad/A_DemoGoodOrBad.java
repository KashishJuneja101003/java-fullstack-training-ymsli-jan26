package com.demo.basics.bad;
//"seprate what varies"


class Bird {
	public void fly() {
		System.out.println("swim");
	}
	
	public void swim() {
		System.out.println("swim");
	}
	void sound() {
		System.out.println("bird sound");
	}
}

class Duck extends Bird{
}

public class A_DemoGoodOrBad {

	public static void main(String[] args) {
		
	}
}
