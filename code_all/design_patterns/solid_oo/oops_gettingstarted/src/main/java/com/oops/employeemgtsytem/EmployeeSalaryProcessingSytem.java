package com.oops.employeemgtsytem;

public class EmployeeSalaryProcessingSytem {

	public static void processPayment(Employee employee) {
		//open a jdbc conn
		double amount = employee.payable();
		System.out.println("payable amount is: "+ amount);
		//put in db
	}
}
