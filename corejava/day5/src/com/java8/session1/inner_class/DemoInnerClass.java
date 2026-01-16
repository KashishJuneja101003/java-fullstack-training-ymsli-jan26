package com.java8.session1.inner_class;


//class Outer{
//	static private int i=88;
//	class Inner{
//		private int i=888;
//		void foo() {
//			System.out.println("foo method of inner clas:"+ Outer.i);
//		}
//	}
//}

//class Outer {
//	public void foo() {
//		class Inner {
//			private int i = 888;
//
//			void foo() {
//				System.out.println("foo method of inner clas:");
//			}
//		}
//		Inner inner=new Inner();
//		inner.foo();
//	}
//}
//lambda is only support iff u have only one abs method
//and if a interface have only one abs method it is called SAM "signle abs method"
@FunctionalInterface
interface Cookable{
	void cook();
}
public class DemoInnerClass {
	public static void main(String[] args) {
		//funda diff bw lambda and ann inner class
		//lambda dont have its own scope it take laxical scope
		Cookable cookable=new Cookable() {
			@Override
			public void cook() {
				System.out.println("street food");
			}
		};
		Cookable cookable2=()-> System.out.println("home food");
		cookable2.cook();
		//java 8 compile java 7--- java 8---java 25
		//type inference 
		
			
	
		
	}

}












