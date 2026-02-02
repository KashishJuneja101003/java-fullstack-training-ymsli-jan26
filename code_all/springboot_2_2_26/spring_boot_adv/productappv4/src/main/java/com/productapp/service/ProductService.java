package com.productapp.service;

import java.util.List;

import com.productapp.entities.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getById(int id);
	public Product addProduct(Product product);
	public Product deteteProduct(int id);
	public Product updateProduct(int id,Product product);
	public void evict();
	
}
