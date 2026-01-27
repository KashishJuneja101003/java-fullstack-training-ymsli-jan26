package com.productapp.dao;

import java.util.Arrays;
import java.util.List;

public class ProductDaoMapImpl implements ProductDao{

	@Override
	public List<String> getAll() {
		System.out.println("map dao impl");
		return Arrays.asList("laptop","laptop stand","marker");
	}

}
