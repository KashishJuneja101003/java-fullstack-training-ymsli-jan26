package com.mcq_discsssion.q06;
//shadowning?
//class A {
//	public static  void f() {
//		System.out.println("fA");
//	}
//}
//
//class B extends A {
//	public static void f() {
//		System.out.println("fB");
//	}
//
//	public static void main(String[] args) {
//		A a = new B();
//		a.f();
//	}
//}

class A {
	 String a="A";
}

class B extends A {
	 String a="B";

	public static void main(String[] args) {
		System.out.println(new B().a);
	}
}
