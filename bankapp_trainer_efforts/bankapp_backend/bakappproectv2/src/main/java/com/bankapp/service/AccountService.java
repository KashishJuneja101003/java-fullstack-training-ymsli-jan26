package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.api.response.AccountWithTxResponse;
import com.bankapp.entities.Account;
import com.bankapp.repo.projections.AccountSummary;
import com.bankapp.repo.projections.TxView;

public interface AccountService {

    public List<Account> getAll();
    
    public Account getById(int id);
	
    public void addAccount(Account account);
    
    
    public void deleteAccount(int id);
    
    public void transfer(int fromAccId, int toAccId, BigDecimal amount);
    
    public void deposit(int accId, BigDecimal amount);
    
    public void withdraw(int accId, BigDecimal amount);
    
    
    AccountWithTxResponse getAccountWithTx(int id);
    
    Account getAccountWithTransactions(int id);

    List<AccountSummary> getAccountSummaries();
    
    AccountSummary getAccountSummaryByAccountNumber(int id);

    List<TxView> getTransactionView(int id);
    
    long getTransactionCount(int id);
}
