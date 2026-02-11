package com.bankapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path="v1/transactions")
public class AccountTransactionController {
	
	private AccountService accountService;

	
	public AccountTransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//transfer
	@PutMapping("transfer")
	public String transfer(@RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccountId(),
				transferDto.getToAccountId(), transferDto.getAmount());
		return "fund transfer successfully";
	}

	@PutMapping("deposit")
	public String deposit(@RequestBody DepositDto depositDto) {
		accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
		return "deposit successfully";
	}
	
	@PutMapping("withdraw")
	public String withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
		return "withdraw successfully";
	}
	
}
