package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.productapp.dao.mappers.ProductMapper;
import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;

@Repository
@Profile("dev")
public class ProductDaoJdbcTemplateImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getAll() {
		System.out.println("jdbc template wala code^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return jdbcTemplate.query("select id, name, price from product", new ProductMapper());
	}

	private void delay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveProduct(Product product) throws FooEx{
		jdbcTemplate
		.update("INSERT INTO product(name, price) VALUES (?, ?)", new Object[] {product.getName(), product.getPrice()});
	
	}

}










