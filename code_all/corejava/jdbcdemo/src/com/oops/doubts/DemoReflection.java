package com.oops.doubts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student {
	int id;
	String name;
	int marks;

	public void foof() {
		System.out.println("hello to java");
	}
	public Student(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	static String schoolName = "abc";
}

class Foo{
	
	private Foo() {
		System.out.println("it is a private ctr");
	}
	public void demo() {
		System.out.println("dare to call me ");
	}
}

public class DemoReflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> clazz=Class.forName("com.oops.doubts.Foo");
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		declaredConstructors[0].setAccessible(true);
		Foo foo = (Foo)declaredConstructors[0].newInstance();
		foo.demo();
//		
//		Student student1 = new Student(1, "raj", 89);//static class loading vs dynamic class loading
//		
//		Student student2 = new Student(1, "ekta", 89);
//
//		Class<?> class1 = student1.getClass();
//		Method[] methods=class1.getDeclaredMethods();
//		for(Method method: methods) {
//			System.out.println(method.getName());
//		}
		
		//java reflection is core java api aka janamparti that can give valuable info about the meta data of the class
		//normal dev dont need it but if u want to understand how framework are created
		
		

	}
}





