package com.productapp.controller;

import java.util.List;

import com.productapp.dto.Product;
import com.productapp.exceptions.ServiceException;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

//REST controller : mean expressjs routes: Spring boot: spring REST
public class ProductController {

	public static void main(String[] args) {
		try {
			ProductService productService=new ProductServiceImpl();
			List<Product> products=productService.getAll();
			products.forEach(p->System.out.println(p));
		}catch(ServiceException exception) {
			exception.printStackTrace();
//			System.out.println(exception.getCause()
//					.getCause());
		}
		
	}
}
