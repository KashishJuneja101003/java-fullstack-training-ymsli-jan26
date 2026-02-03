package com.dp.structural.d.facade;
public class AccountService {
    public void debit(String accountId, double amount) {
        System.out.println("Debiting " + amount + " from account " + accountId);
    }

    public void credit(String accountId, double amount) {
        System.out.println("Crediting " + amount + " to account " + accountId);
    }
}
