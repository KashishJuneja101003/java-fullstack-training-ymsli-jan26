package com.bankapp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.api.request.AccountRequest;
import com.bankapp.api.response.AccountResponse;
import com.bankapp.api.response.AccountWithTxResponse;
import com.bankapp.entities.Account;
import com.bankapp.entities.BankTxType;
import com.bankapp.entities.TxHistory;
import com.bankapp.mapper.AccountMapper;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.TxHistoryRepo;
import com.bankapp.repo.projections.AccountSummary;
import com.bankapp.repo.projections.TxView;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepo accountRepo;
	private final TxHistoryRepo txHistoryRepo;
	private final AccountMapper accountMapper;

	@Override
	public List<AccountResponse> getAll() {
		return accountRepo.findAll().stream().map(accountMapper::toResponse).toList();
	}

	@Override
	public AccountResponse getById(int id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found: " + id));

		return accountMapper.toResponse(account);
	}

	@Override
	public AccountResponse addAccount(AccountRequest request) {
		Account account = accountMapper.toEntity(request);
		accountRepo.save(account);
		return accountMapper.toResponse(account);
	}

	private Account getAccountEntity(int id) {
	    return accountRepo.findById(id)
	            .orElseThrow(() ->
	                    new RuntimeException("Account not found: " + id));
	}
	
	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {

		if (fromAccId == toAccId) {
			throw new RuntimeException("Source and destination accounts must be different");
		}

		Account from = getAccountEntity(fromAccId);
		Account to = getAccountEntity(toAccId);

		if (from.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient balance");
		}

		// debit
		BigDecimal fromNewBal = from.getBalance().subtract(amount);

		from.setBalance(fromNewBal);

		txHistoryRepo.save(buildTx(BankTxType.TRANSFER_OUT, amount, fromNewBal, from));

		// credit
		BigDecimal toNewBal = to.getBalance().add(amount);

		to.setBalance(toNewBal);

		txHistoryRepo.save(buildTx(BankTxType.TRANSFER_IN, amount, toNewBal, to));

		accountRepo.save(from);
		accountRepo.save(to);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {

		Account account = getAccountEntity(accId);

		BigDecimal newBalance = account.getBalance().add(amount);
		account.setBalance(newBalance);

		TxHistory tx = buildTx(BankTxType.DEPOSIT, amount, newBalance, account);

		txHistoryRepo.save(tx);
		accountRepo.save(account);
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {

		Account account = getAccountEntity(accId);

		if (account.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient balance");
		}

		BigDecimal newBalance = account.getBalance().subtract(amount);
		account.setBalance(newBalance);

		TxHistory tx = buildTx(BankTxType.WITHDRAW, amount, newBalance, account);

		txHistoryRepo.save(tx);
		accountRepo.save(account);
	}

	private TxHistory buildTx(BankTxType type, BigDecimal amount, BigDecimal balanceAfter, Account account) {
		TxHistory tx = new TxHistory();
		tx.setType(type);
		tx.setAmount(amount);
		tx.setBalanceAfterTx(balanceAfter);
		tx.setTxTime(LocalDateTime.now());
		tx.setAccount(account);
		return tx;
	}

	@Override
	public AccountWithTxResponse getAccountWithTx(int id) {

		// 1. Load Account entity (no JSON here)
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

		// 2. Load transactions using projection (NO N+1)
		List<TxView> transactions = txHistoryRepo.findTxByAccountId(id);

		// 3. Combine into DTO
		return new AccountWithTxResponse(account.getId(), account.getName(), account.getBalance(), transactions);
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete = getAccountEntity(id);
		accountRepo.delete(accountToDelete);
	}

	@Override
	public Account getAccountWithTransactions(int id) {
		return accountRepo.findAccountWithTransactions(id)
				.orElseThrow(() -> new RuntimeException("Account not found: " + id));
	}

	@Override
	public List<AccountSummary> getAccountSummaries() {
		return accountRepo.findAccountSummaries();
	}

	@Override
	public AccountSummary getAccountSummaryByAccountNumber(int id) {
		return accountRepo.findAccountSummaryById(id)
				.orElseThrow(() -> new RuntimeException("Account not found: " + id));
	}

	@Override
	public List<TxView> getTransactionView(int id) {
		return txHistoryRepo.findTxByAccountId(id);
	}

	@Override
	public long getTransactionCount(int id) {
		return txHistoryRepo.countTxForAccount(id);
	}

}
