package com.bankapp.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.api.request.AccountRequest;
import com.bankapp.api.response.AccountDetailUpdateRequest;
import com.bankapp.api.response.AccountResponse;
import com.bankapp.entities.Account;
import com.bankapp.services.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "v1/accounts")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public List<AccountResponse> getAll() {
		return accountService.getAll();
	}

	@GetMapping(path = "{id}")
	public AccountResponse getById(@PathVariable(name = "id") int id) {
		return accountService.getById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id) {
		 accountService.deleteAccount(id);
		 return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<AccountResponse> updateAccount(@PathVariable(name = "id") int id, 
			@RequestBody AccountDetailUpdateRequest accountDetailUpdateRequest) {
	    AccountResponse updatedAccountResponse = accountService.updateAccount(id, accountDetailUpdateRequest);
	    return ResponseEntity
	            .status(HttpStatus.OK)
	            .body(updatedAccountResponse);
	}
	
	@PostMapping
	public ResponseEntity<AccountResponse> addAccount(@Valid @RequestBody AccountRequest accountRequest) {
	    AccountResponse savedAccountResponse = accountService.addAccount(accountRequest);
	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(savedAccountResponse);
	}

}
