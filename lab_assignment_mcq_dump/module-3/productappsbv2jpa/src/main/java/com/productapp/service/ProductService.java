package com.productapp.service;

import java.util.List;

import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;

public interface ProductService {
	public List<Product> getAllProduct();
	public void saveProduct(Product product)throws FooEx;
}
