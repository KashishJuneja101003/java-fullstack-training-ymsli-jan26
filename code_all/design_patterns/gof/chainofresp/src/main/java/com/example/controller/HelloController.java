package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path="hello")
	public String hello() {
		System.out.println("hello form hello routes");
		return "hello mvc";
	}

}
