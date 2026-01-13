package com.day2.session1;

import java.util.Collections;

//why defualt and static
//i am sr dev in ur ymsli
//interface Stack{
//	public int pop();
//	public void push(int i);
//	
//	public default int peek() {
//		return 4;
//	}
//}
//class StackImpl2 implements Stack{
//
//	@Override
//	public int pop() {
//		return 0;
//	}
//
//	@Override
//	public void push(int i) {
//		
//	}
//	
//}
//class StackImpl1 implements Stack{
//
//	@Override
//	public int pop() {
//		return 0;
//	}
//
//	@Override
//	public void push(int i) {
//		
//	}
//	
//}

interface P{
	default void foo() {
		System.out.println("foo method p");
	}
}
interface Q{
	default void foo() {
		System.out.println("foo method Q");
	}
}

class Z implements P, Q{
	@Override
	public void foo() {
		Q.super.foo();
		System.out.println("foo method Overriden");
	}
}

public class WhyJava8Default {
	
	public static void main(String[] args) {
		Q p=new Z();
		p.foo();
	}

}
