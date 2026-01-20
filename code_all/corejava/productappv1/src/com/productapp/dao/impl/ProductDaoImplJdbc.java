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
import com.productapp.util.ConnectionFactory;

public class ProductDaoImplJdbc implements ProductDao {

	private Connection connection;

	public ProductDaoImplJdbc() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void addProduct(Product product) {
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into product(name,price)values (?,?)");
			pstmt.setString(1, product.getName());
			pstmt.setDouble(2, product.getPrice());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
