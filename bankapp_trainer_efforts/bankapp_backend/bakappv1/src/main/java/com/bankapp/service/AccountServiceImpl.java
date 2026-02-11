package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountDao.getById(id);
		if (account == null) {
			throw new BankAccountNotFoundException("account with id " + id + " not found");
		}
		return account;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));

		accountDao.updateAccount(fromAcc);

		toAcc.setBalance(toAcc.getBalance().add(amount));

		accountDao.updateAccount(toAcc);

	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().add(amount));
		accountDao.updateAccount(acc);

	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountDao.updateAccount(acc);
	}

	
	
	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub

	}

}
