package com.productapp.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.productapp.dto.Product;
import com.productapp.excetions.FooEx;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
@Repository
@Profile("prod")
public class ProductDaoJpaImpl implements ProductDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getAll() {
		System.out.println("-----------------------------");
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public void saveProduct(Product product)  {
		em.persist(product);
	}
}
