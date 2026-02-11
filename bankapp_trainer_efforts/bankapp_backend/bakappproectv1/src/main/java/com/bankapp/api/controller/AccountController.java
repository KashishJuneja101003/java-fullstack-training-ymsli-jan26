package com.bankapp.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.api.request.DepositRequest;
import com.bankapp.api.request.WithdrawRequest;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "v1/accounts")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public List<Account> getAll() {
		return accountService.getAll();
	}

	@GetMapping(path = "{id}")
	public Account getById(@PathVariable(name = "id") int id) {
		return accountService.getById(id);
	}

}
