package com.productapp.service;

import java.util.List;

import com.productapp.dto.Product;

public interface ProductService {
	List<Product>getAll();
	void addProduct(Product product);
}
