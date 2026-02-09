package com.bankapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.LoginRequest;

@RestController
public class HelloController {
	
	//endpoint register
	@PostMapping(path = "register")
	public String register(@RequestBody LoginRequest loginRequest) {
		
		return "register";
	}
	
    @GetMapping(path = "home")
    public String home(){
        return "home";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(path = "admin")
    public String admin(){
        return "admin";
    }
    @PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    @GetMapping(path = "mgr")
    public String mgr(){
        return "mgr";
    }

    @GetMapping(path = "clerk")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    public String clerk(){
        return "clerk";
    }
}


