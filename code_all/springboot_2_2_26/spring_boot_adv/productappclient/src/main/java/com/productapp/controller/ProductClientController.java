package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productapp.dto.Product;

@RestController
public class ProductClientController {

	private RestTemplate restTemplate;

	@Autowired
	public ProductClientController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping(path = "productclient/{id}")
	public Product getById(@PathVariable(name="id") int id) {
		return restTemplate
				.getForObject("http://localhost:8090/productapp/v1/products/"+ id, Product.class);
	}
	
}
