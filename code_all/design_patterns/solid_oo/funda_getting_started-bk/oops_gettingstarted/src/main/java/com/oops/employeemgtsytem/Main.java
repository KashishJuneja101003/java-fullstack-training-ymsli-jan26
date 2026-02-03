package com.oops.employeemgtsytem;

public class Main {

	public static void main(String[] args) {
		Employee employee1=new PartTimeEmployee(1, "ravi", 20000, 12, 1200);
		Employee employee2=new FullTimeEmployee(2, "amit", 56000, "ABA1323");
		
		Invoice invoice=new Invoice("12A", "abc", 2, 40000);
		
		
		EmployeeSalaryProcessingSytem.processPayment(employee1);
		EmployeeSalaryProcessingSytem.processPayment(employee2);
	
	}
}
