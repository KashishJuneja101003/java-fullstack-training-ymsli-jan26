package com.oops.employeemgtsytem;

public class PartTimeEmployee extends Employee {
	private int noOfDays;
	private int ratePerDay;

	public PartTimeEmployee(int id, String name, double amount, int noOfDays, int ratePerDay) {
		super(id, name, amount);
		this.noOfDays = noOfDays;
		this.ratePerDay = ratePerDay;
	}

	public double payable() {
		return (super.getAmount()+ noOfDays*ratePerDay)*0.7;
	}

}
