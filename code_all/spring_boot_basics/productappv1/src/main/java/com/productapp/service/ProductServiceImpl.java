package com.productapp.service;

import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoJdbcImpl;
import com.productapp.dao.ProductDaoMapImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<String> getAllProduct() {
		return productDao.getAll();
	}

}
