package com.dp.structural.d.facade;
public class LedgerService {
    public void record(String from, String to, double amount) {
        System.out.println("Ledger updated: Transfer of " + amount + " from " + from + " to " + to);
    }
}