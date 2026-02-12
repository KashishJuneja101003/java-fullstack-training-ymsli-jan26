package com.bankapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;

@Component
public class DbInit {

	@Autowired
	private AccountRepo accountRepo;

	@Bean
	public CommandLineRunner commandLineRunner() {

		return (String... args) ->{
//				accountRepo.save(Account.builder().name("amit").balance(BigDecimal.valueOf(1000))
//						.email("amit@gmail.com").phone("6622334477").build());
//				accountRepo.save(Account.builder().name("sumit").balance(BigDecimal.valueOf(1000))
//						.email("sumit@gmail.com").phone("9922334477").build());
				
			
		};
	}

}
