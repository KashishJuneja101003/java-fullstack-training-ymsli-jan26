package com.productapp.dao;

import java.util.Arrays;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao{

	@Override
	public List<String> getAll() {
		System.out.println("jdbc dao impl");
		return Arrays.asList("laptop","laptop stand","marker");
	}

}
