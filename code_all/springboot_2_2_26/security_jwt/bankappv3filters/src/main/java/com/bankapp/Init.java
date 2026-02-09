package com.bankapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;

@Component
public class Init implements CommandLineRunner {

	@Autowired
	private UserEntityService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
//		userService.addUserEntity(new UserEntity("raj", 
//				passwordEncoder.encode("raj123"),
//				List.of("ROLE_ADMIN", "ROLE_MGR", "ROLE_CLERK")));
//
//		userService.addUserEntity(
//				new UserEntity("ekta", 
//						passwordEncoder.encode("ekta123"), 
//						List.of("ROLE_MGR", "ROLE_CLERK")));
//
//		userService.addUserEntity(
//				new UserEntity("abc", passwordEncoder.encode("abc123"), 
//						List.of("ROLE_MGR", "ROLE_CLERK")));
	}

}
