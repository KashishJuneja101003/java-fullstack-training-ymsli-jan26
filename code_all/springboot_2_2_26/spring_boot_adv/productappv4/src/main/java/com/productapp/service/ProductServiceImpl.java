package com.productapp.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;
	private final ObservationRegistry observationRegistry;
	

	public ProductServiceImpl(ProductRepo productRepo, ObservationRegistry observationRegistry) {
		this.productRepo = productRepo;
		this.observationRegistry = observationRegistry;
	}

	
	@Override
	public List<Product> getAll() {
        return Observation.createNotStarted("product.findAll", observationRegistry)
                .observe(() -> productRepo.findAll());
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

	@CacheEvict(value="products", key="#id")
	@Override
	public Product deteteProduct(int id) {
		Product productToDelete= getById(id);
		productRepo.delete(productToDelete);
		return null;
	}

	@CachePut(value="products", key="#result.id")
	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productRepo.save(productToUpdate);
		
		return productToUpdate;
	}

	@CacheEvict(value="products", allEntries=true)
	@Override
	public void evict() {}

}
