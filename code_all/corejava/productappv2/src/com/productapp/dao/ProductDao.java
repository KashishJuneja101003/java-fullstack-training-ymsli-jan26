package com.productapp.dao;

import java.util.List;

import com.productapp.dto.Product;
import com.productapp.exceptions.DataAccessException;

public interface ProductDao {
	List<Product>getAll();
	void addProduct(Product product);
}
