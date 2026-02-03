package com.dp.structural.d.facade;
public class FraudService {
    public boolean validate(String from, String to, double amount) {
        System.out.println("Validating fraud for " + amount + " transfer...");
        return amount < 100000; // simple rule
    }
}