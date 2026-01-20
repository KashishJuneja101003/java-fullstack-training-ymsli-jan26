package com.productapp.dao;

import java.util.List;

import com.productapp.dto.Product;

public interface ProductDao {
	List<Product>getAll();
	void addProduct(Product product);
}
