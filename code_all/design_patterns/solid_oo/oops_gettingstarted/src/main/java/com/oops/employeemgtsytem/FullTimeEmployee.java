package com.oops.employeemgtsytem;

public class FullTimeEmployee extends Employee {

	private String ppfNumber;
	
	public FullTimeEmployee(int id, String name, double amount, String ppfNumber) {
		super(id, name, amount);
		this.ppfNumber = ppfNumber;
	}

	public double payable() {
		return super.getAmount()*0.7;
	}
	public void printEmpDetails() {
		super.printEmpDetails();
		System.out.println("ppf Number: "+ ppfNumber);
	}

}
