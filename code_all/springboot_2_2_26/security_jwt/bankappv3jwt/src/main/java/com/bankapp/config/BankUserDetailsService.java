package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;

@Service
public class BankUserDetailsService implements UserDetailsService {

	@Autowired
	private UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = userEntityService.findByUsername(username);
		//some how i convert my user to the user that is understood by spring sec
		return new SecUser(userEntity);
	}

}
