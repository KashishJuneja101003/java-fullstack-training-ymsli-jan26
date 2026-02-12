package com.bankapp.services;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.api.request.AccountRequest;
import com.bankapp.api.response.AccountDetailUpdateRequest;
import com.bankapp.api.response.AccountResponse;
import com.bankapp.entities.Account;

public interface AccountService {
	
    public List<AccountResponse> getAll();
    
    public AccountResponse getById(int id);
	
    public AccountResponse addAccount(AccountRequest account);
    
    public void deleteAccount(int id);
    
    public AccountResponse updateAccount(int id, AccountDetailUpdateRequest account);

    public void transfer(int fromAccId, int toAccId, BigDecimal amount);
    
    public void deposit(int accId, BigDecimal amount);
    
    public void withdraw(int accId, BigDecimal amount);
}