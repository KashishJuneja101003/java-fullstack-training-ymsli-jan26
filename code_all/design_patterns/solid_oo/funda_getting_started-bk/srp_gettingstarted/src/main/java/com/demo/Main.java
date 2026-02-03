package com.demo;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Product product=new Product("pen",800.00);
		product.addProduct();
	}
}
