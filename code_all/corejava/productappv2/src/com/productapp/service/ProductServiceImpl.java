package com.productapp.service;

import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dao.impl.ProductDaoImplJdbc;
import com.productapp.dao.impl.ProductDaoImplJpa;
import com.productapp.dto.Product;
import com.productapp.exceptions.DataAccessException;
import com.productapp.exceptions.ServiceException;
//SL brain of ur app== BL + CCC*
public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	private ProductValidation productValidation;
	
	public ProductServiceImpl() {
		productDao=new ProductDaoImplJpa();
		productValidation=new ProductValidationImpl();
	}
	@Override
	public List<Product> getAll() {
		long start= System.currentTimeMillis();
		List<Product> products=null;
		try {
			products=productDao.getAll();
		}catch(DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
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
