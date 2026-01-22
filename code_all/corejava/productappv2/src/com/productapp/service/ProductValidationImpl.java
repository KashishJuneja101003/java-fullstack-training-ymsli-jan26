package com.productapp.service;

import com.productapp.dto.Product;

public class ProductValidationImpl implements ProductValidation{

	@Override
	public boolean isValid(Product product) {
		//regex in java
		return true;
	}

}
