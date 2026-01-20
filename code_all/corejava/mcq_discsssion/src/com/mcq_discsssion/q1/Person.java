package com.mcq_discsssion.q1;
class Mammel{
	
}
abstract public class Person extends Mammel implements Runnable{
	public String name;

	public static void main(String str[]) {
		
		
		
		Mammel p = new Person() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		System.out.print(p instanceof Runnable);
	}

}