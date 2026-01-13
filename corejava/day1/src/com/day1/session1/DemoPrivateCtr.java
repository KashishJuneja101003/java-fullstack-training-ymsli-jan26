package com.day1.session1;

class Foo{
	private static Foo f=new Foo();
	private Foo() {
		System.out.println("ctr can be private .. dare to me");
	}
	public static Foo getFoo() {
		return f;
	}
}

public class DemoPrivateCtr {
	
	public static void main(String[] args) {
		
		Foo f=Foo.getFoo();
		System.out.println(f.hashCode());
		Foo f2=Foo.getFoo();
		System.out.println(f2.hashCode());
		
	}

}
