package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		A a=(A) ctx.getBean("a");
		A a1=(A) ctx.getBean("a");
	
		a.demo();
		a1.demo();
		
//		B b=(B) ctx.getBean("b");
//		System.out.println(b.hashCode());
//		B b2=(B) ctx.getBean("b");
//		
//		System.out.println(b2.hashCode());
		
		
	}
}
