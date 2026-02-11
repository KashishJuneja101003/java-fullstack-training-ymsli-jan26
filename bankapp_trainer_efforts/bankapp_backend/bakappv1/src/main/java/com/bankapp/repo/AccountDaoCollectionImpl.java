package com.bankapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
@Repository
public class AccountDaoCollectionImpl implements AccountDao{
	private Map<Integer, Account> accounts=new HashMap<>();
	
	public AccountDaoCollectionImpl() {
		accounts.put(1, new Account(1, "raj", BigDecimal.valueOf(1000.00)));
		accounts.put(2, new Account(2, "ekta", BigDecimal.valueOf(1000.00)));
	}
	@Override
	public List<Account> getAll() {
		System.out.println("getAll using hard coded collection...");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		return accounts.get(id);
	}

	@Override
	public void updateAccount(Account account) {
		accounts.put(account.getId(), account);
	}
	
	
	
	@Override
	public void addAccount(Account account) {
		
	}
	@Override
	public void deleteAccount(int id) {
		
	}

}