package com.mcq.q20;

class Base {
	public Double getValue() {
		return 1.0;// 1
	}
}

class Base2 extends Base {
	public Number getValue() {
		return null;// 2
	}
}

public class Demo4 {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue()); // 3
	}
}