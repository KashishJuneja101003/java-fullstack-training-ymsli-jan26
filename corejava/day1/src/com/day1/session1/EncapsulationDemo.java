package com.day1.session1;
//Encapsualation: data hinding
class Account{
	
	private int id;
	private String name;
	private double balance;
	private static String bankName="SBI";
	
	
	public Account() {
		
	}
	public Account(Account account) {}
	
	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(int amount) {
		
	}
	
	public void print() {
		System.out.println("id:"+ id +" name: " + name+" amount: "+ balance);
	}
	
}
public class EncapsulationDemo {
	
	public static void main(String[] args) {
		Account account=new Account();
		
//		Class clazz=account.getClass();
//		clazz.get
//		
//		
		
		
	}

}
