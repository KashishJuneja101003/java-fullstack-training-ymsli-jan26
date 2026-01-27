package com.productapp.dao;

import java.util.Arrays;
import java.util.List;

import com.productapp.dto.Product;

public class ProductDaoArrayListImpl implements ProductDao{
	 @Override
	    public List<Product> getAll() {
	        System.out.println("jdbc ArrayList impl");

	        return Arrays.asList(
	            new Product(1, "Laptop", 75000.00),
	            new Product(2, "Laptop Stand", 1500.00),
	            new Product(3, "Marker", 50.00)
	        );
	    }

}
