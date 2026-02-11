package com.bankapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
@Component
public class DbInit implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("ekta", BigDecimal.valueOf(1000)));
		
		accountRepo.save(new Account("rajeev", BigDecimal.valueOf(1000)));
		
	}

}
