package com.bankapp.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankapp.repo.UserEntity;
//Juddad so that my UserEntiy should be conveted to user details
public class SecUser implements UserDetails{

	private static final long serialVersionUID = 1296629136901464383L;
	private UserEntity userEntity;
	
	public SecUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return AuthorityUtils.createAuthorityList(userEntity.getRoles());
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	
}
