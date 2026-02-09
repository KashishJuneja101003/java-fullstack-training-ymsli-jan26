package com.productapp.dao;

import java.util.List;

import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;

public interface ProductDao {
	public List<Product> getAll();
	public void saveProduct(Product product)throws FooEx;
}
