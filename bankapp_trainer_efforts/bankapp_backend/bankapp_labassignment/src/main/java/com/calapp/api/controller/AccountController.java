package com.calapp.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calapp.api.response.AccountRequest;

@RestController
public class AccountController {

    @GetMapping("/accounts")
    public List<AccountRequest> getAccounts() {

        AccountRequest acc1 =
                new AccountRequest(1, "Raj", new BigDecimal("1000.00"));

        AccountRequest acc2 =
                new AccountRequest(2, "Amit", new BigDecimal("2500.50"));

        return List.of(acc1, acc2);
    }
}