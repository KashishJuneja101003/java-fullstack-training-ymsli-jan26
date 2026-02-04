package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Order;

@RestController
public class ProducerController {

	@Autowired
	private ProducerService producerService;

	@PostMapping(path = "orders")
	public ResponseEntity<String> sendMessage( @RequestBody Order order) {
		producerService.produce(order);

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body("message is booked");
	}
}
