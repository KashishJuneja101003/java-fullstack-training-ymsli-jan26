package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;

import jakarta.validation.Valid;

//@CrossOrigin
@RestController
@RequestMapping(path = "v1")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("products")
//	@GetMapping(path = "products", 
//			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	@GetMapping("products/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
	}

	@DeleteMapping("products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id) {
		productService.deteteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("products/{id}")
	public ResponseEntity<Product> updateById(@PathVariable(name = "id") int id, @RequestBody Product product) {
		Product updateProduct = productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
	}
	
//	@PostMapping(path = "products2", 
//			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
//			consumes  = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	public ResponseEntity<Product> addProductV2(@Valid @RequestBody Product product) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
//	}

	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}
}

//@RestController
//public class ProductController {
//	
//	private ProductService productService;
//
//	@Autowired
//	public ProductController(ProductService productService) {
//		this.productService = productService;
//	}
//	
//	
//	@GetMapping("products")
//	public List<Product> getAll(){
//		return productService.getAll();
//	}
//	
//
//	@GetMapping("products/{id}")
//	public Product getById(@PathVariable(name = "id") int id){
//		return productService.getById(id);
//	}
//	
//	@DeleteMapping("products/{id}")
//	public Product deleteById(@PathVariable(name = "id") int id){
//		return productService.deteteProduct(id);
//	}
//	
//	@PutMapping("products/{id}")
//	public Product updateById(@PathVariable(name = "id") int id,@RequestBody Product product){
//		return productService.updateProduct(id, product);
//	}
//	
//	@PostMapping("products")
//	public Product addProduct(@RequestBody Product product){
//		return productService.addProduct(product);
//	}
//}
