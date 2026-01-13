package com.day2.session1;
class A{
	static void a() {
		System.out.println("it is a method 1");
	}
}

class B extends A{
	static void a() {
		System.out.println("it is a method 2");
	}
}

public class DemoStaticAndOveriding {

	public static void main(String[] args) {
		//The static method a() from the type A should be accessed in a static way
		B a=new B();
		A.a();
	}
}
