package com.oops.employeemgtsytem;

abstract public class Employee {

	private int id;
	private String name;
	private double amount;
	public Employee(int id, String name, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	

	public double getAmount() {
		return amount;
	}


	
	public void printEmpDetails() {
		System.out.println("emp details : "+ id+" name: "+ name+" base salary: "+ amount);
	}


	protected abstract double payable();
}
