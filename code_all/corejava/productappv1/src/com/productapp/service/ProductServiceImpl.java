package com.productapp.service;

import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dao.impl.ProductDaoImplJdbc;
import com.productapp.dto.Product;
//SL brain of ur app== BL + CCC*
public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	private ProductValidation productValidation;
	
	public ProductServiceImpl() {
		productDao=new ProductDaoImplJdbc();
		productValidation=new ProductValidationImpl();
	}
	@Override
	public List<Product> getAll() {
		long start= System.currentTimeMillis();
		List<Product> products=productDao.getAll();
		long end= System.currentTimeMillis();
		System.out.println("time taken is : "+ (end-start)+" ms");
		return products;
	}

	@Override
	public void addProduct(Product product) {
		if(productValidation.isValid(product)) {
			productDao.addProduct(product);
		}
	}

}
