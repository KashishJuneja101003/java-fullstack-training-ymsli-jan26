package com.mcq.q6;

class A {
	public static void f() {
		System.out.println("fA");
	}
}

class B extends A {
	public void f() {
		System.out.println("fB");
	}

	public static void main(String[] args) {
		A a = new B();
		a.f();
	}
}