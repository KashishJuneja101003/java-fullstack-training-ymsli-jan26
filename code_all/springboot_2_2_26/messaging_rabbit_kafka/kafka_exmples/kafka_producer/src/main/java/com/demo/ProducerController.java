package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping(path="producer/{message}")
	public String sendMessage(@PathVariable  String message) {
		  for(int i=0;i<5000;i++){
			  	producerService.produce(message+ " "+ i);
		  }
		return "message is send";
	}
}
