package com.productapp.controller;

import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoArrayListImpl;
import com.productapp.dto.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {

	public static void main(String[] args) {
		ProductDao productDao=new ProductDaoArrayListImpl();
		ProductService productService=new ProductServiceImpl(productDao);
		
		List<Product> proList=productService.getAllProduct();
		proList.forEach(p-> System.out.println());
	}
}
