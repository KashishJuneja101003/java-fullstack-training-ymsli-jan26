package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dto.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getById(int id) {
		return productRepo.findById(id)
				.orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));
	}

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product deteteProduct(int id) {
		Product productToDelete= getById(id);
		productRepo.delete(productToDelete);
		return null;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productRepo.save(productToUpdate);
		
		return productToUpdate;
	}

}
