package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;
import com.productapp.service.aspect.MyLogger;
@Service(value = "ps")
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional(readOnly = true, timeout = 1000)
	@MyLogger
	@Override
	public List<Product> getAllProduct() {
		List<Product> products= productDao.getAll();
		return products;
	}

	@Transactional(readOnly = false, 
			isolation = Isolation.READ_COMMITTED, 
			noRollbackFor = {Exception.class},
			rollbackFor = {FooEx.class})
	@Override
	public void saveProduct(Product product) throws FooEx{
		productDao.saveProduct(product);
		if(1==1)
			throw new FooEx("some foo ex");
	}

}









