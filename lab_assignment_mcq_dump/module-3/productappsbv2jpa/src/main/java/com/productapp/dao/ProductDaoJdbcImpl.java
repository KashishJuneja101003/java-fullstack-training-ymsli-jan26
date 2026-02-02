package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;

//@Repository
public class ProductDaoJdbcImpl implements ProductDao {

	private DataSource dataSource;

	@Autowired
	public ProductDaoJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> getAll() {

		System.out.println("jdbc dao impl");

		String sql = "select id, name, price from product";
		List<Product> products = new ArrayList<>();

		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
				products.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException("DB error while fetching products", e);
		}

		return products;
	}

	private void delay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveProduct(Product product) throws FooEx{
		String sql = "INSERT INTO products(name, price) VALUES (?, ?)";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			// 1️⃣ start transaction
			connection.setAutoCommit(false);

			try (PreparedStatement psmt = connection.prepareStatement(sql)) {

				psmt.setString(1, product.getName());
				psmt.setDouble(2, product.getPrice());
				psmt.executeUpdate();
			}

			// 2️⃣ commit if everything is fine
			connection.commit();

		} catch (SQLException e) {

			// 3️⃣ rollback on failure
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

			throw new RuntimeException("Failed to save product", e);

		} finally {

			// 4️⃣ cleanup
			if (connection != null) {
				try {
					connection.setAutoCommit(true); // important
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
