package com.productapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import com.productapp.exceptions.DataAccessException;
import com.productapp.exceptions.PersistenceException;
import com.productapp.util.ConnectionFactory;

public class ProductDaoImplJpa implements ProductDao {

	private Connection connection;

	public ProductDaoImplJpa() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		try {

			if(1==1)
				throw new PersistenceException("some jpa hell");
		} catch (PersistenceException e) {
			throw new DataAccessException(e.getMessage(), e);
		}
		return products;
	}

	@Override
	public void addProduct(Product product) {
		try {

			if(1==1)
				throw new PersistenceException("some jpa hell");
		} catch (PersistenceException e) {
			throw new DataAccessException(e.getMessage(), e);
		}
	}

}
