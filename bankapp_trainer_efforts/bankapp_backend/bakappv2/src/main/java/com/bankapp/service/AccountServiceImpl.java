package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepo accountRepo;
	

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountRepo.findById(id)
				.orElseThrow(()-> new BankAccountNotFoundException("account with id " + id + " not found"));
		return account;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));

		accountRepo.save(fromAcc);

		
		
		toAcc.setBalance(toAcc.getBalance().add(amount));

		accountRepo.save(toAcc);

	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.save(acc);

	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.save(acc);
	}

	
	
	@Override
	public void addAccount(Account account) {
		accountRepo.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete= getById(id);
		accountRepo.delete(accountToDelete);
	}

}
