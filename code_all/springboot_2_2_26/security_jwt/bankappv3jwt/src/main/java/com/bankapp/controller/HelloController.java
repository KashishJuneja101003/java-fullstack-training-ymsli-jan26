package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.JwtService;
import com.bankapp.dto.AuthRequest;

@RestController
public class HelloController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	@PostMapping(path = "authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), 
						authRequest.getPassword()));
		//authentication i need to validate this object
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userDetailsService.loadUserByUsername(authRequest.getUsername()));
        }else {
            throw  new UsernameNotFoundException("user is invalid");
        }
	}

	@GetMapping(path = "home")
	public String home() {
		return "home";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping(path = "admin")
	public String admin() {
		return "admin";
	}

	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	@GetMapping(path = "mgr")
	public String mgr() {
		return "mgr";
	}

	@GetMapping(path = "clerk")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public String clerk() {
		return "clerk";
	}
}
