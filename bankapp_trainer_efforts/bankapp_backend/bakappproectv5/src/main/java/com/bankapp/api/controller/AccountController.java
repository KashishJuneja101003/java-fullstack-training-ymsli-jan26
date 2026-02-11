package com.bankapp.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.api.request.AccountRequest;
import com.bankapp.api.response.AccountResponse;
import com.bankapp.api.response.AccountWithTxResponse;
import com.bankapp.entities.Account;
import com.bankapp.repo.projections.AccountSummary;
import com.bankapp.service.AccountService;

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

	@PostMapping
	public AccountResponse addAccount(@RequestBody AccountRequest accountRequest) {
		return accountService.addAccount(accountRequest);
	}
	
//	@GetMapping(path = "{id}")
//	public Account getById(@PathVariable(name = "id") int id) {
//		return accountService.getById(id);
//	}

	@GetMapping("{id}")
	public AccountWithTxResponse getById(@PathVariable int id) {
		return accountService.getAccountWithTx(id);
	}
    //  Fetch join – N+1 safe
    @GetMapping("{id}/with-transactions")
    public Account getAccountWithTransactions(@PathVariable int id) {
        return accountService.getAccountWithTransactions(id);
    }

	//  PROJECTION READ (API SAFE)
    @GetMapping("summary")
    public List<AccountSummary> getAccountSummaries() {
        return accountService.getAccountSummaries();
    }

    @GetMapping("summary/by-account-number/{id}")
    public AccountSummary getAccountSummaryByAccountNumber(
            @PathVariable int id) {
        return accountService.getAccountSummaryByAccountNumber(id);
    }
}
