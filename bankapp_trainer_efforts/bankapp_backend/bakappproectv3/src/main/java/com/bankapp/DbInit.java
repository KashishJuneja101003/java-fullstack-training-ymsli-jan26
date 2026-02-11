package com.bankapp;

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
		//public Account(String name, BigDecimal balance, String email, String phone)
	//	accountRepo.save(new Account("amit", BigDecimal.valueOf(1000),"amit@gmail.com","5544335544"));
//		
	//	accountRepo.save(new Account("sumit", BigDecimal.valueOf(1000),"sumit@gmail.com","6644335544"));
		
	}

}
