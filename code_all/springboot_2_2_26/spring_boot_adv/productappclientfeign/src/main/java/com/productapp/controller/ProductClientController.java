package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productapp.dto.Product;
import com.productapp.serviceproxy.ProductServiceProxy;

@RestController
public class ProductClientController {

	private ProductServiceProxy productServiceProxy;
	
	public ProductClientController(ProductServiceProxy productServiceProxy) {
		this.productServiceProxy = productServiceProxy;
	}



	@GetMapping(path = "productclient/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name="id") int id) {
		return productServiceProxy.findById(id);
	}
	
}
