package com.mcq.q20;

class Cat {
	public static String foo = "value";
}

class CostlyCat extends Cat {
	private static String foo = "value2";
}

public class Demo {
	public static void main(String[] args) {
		System.out.println(new CostlyCat().foo);
	}
}