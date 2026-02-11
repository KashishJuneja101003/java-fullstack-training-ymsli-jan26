package com.productapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.productapp.dto.Product;

public interface ProductRepo extends MongoRepository<Product, String>{

}
