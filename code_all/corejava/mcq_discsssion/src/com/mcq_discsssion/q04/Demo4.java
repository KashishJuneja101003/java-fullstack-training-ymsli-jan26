package com.mcq_discsssion.q04;
//overriding: covarienet retrun type
class Base {
    public Number getValue() {
        return 1.0; // 1
    }
}

class Base2 extends Base {
    public Double getValue() {
    	return null; // 2
    }
}

public class Demo4 {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue()); // 3
	}
}
