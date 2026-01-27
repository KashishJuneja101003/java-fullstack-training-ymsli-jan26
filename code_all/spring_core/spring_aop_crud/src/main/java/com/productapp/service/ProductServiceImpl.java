package com.productapp.service;

import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoJdbcImpl;
import com.productapp.dto.Product;
import com.productapp.dao.ProductDaoArrayListImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAll();
	}

}
