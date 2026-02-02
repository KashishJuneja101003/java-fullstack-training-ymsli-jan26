package com.productapp.serviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productapp.dto.Product;

@FeignClient(name="product-service", url="http://localhost:8090/productapp/v1")  
public interface ProductServiceProxy {

	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> findById(@PathVariable(name = "id") int id);
}
