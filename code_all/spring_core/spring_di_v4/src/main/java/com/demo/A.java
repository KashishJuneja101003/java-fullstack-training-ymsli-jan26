package com.demo;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
 public class A {
	
	public void demo() {
		B b = getB();
		System.out.println(b.hashCode());
		b.foo();
	}

	@Lookup
	 B getB() {
		return null; // Spring overrides this method
	}
	
	
	
//	@Autowired
//	 B b;
//	
//	public void demo() {
//		System.out.println(b.hashCode());
//		b.foo();
//	}

}
