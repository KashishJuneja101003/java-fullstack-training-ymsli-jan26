package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.productapp.dto.Product;
import com.productapp.repo.ProductRepo;
@EnableAspectJAutoProxy
@SpringBootApplication
public class Productappv1Application implements CommandLineRunner{
	
	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
	SpringApplication.run(Productappv1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		productRepo.save(new Product("Laptop", BigDecimal.valueOf(78900.00)));
//		productRepo.save(new Product("Laptop stand", BigDecimal.valueOf(700.00)));
	}
}

