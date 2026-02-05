package com.demo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class B_ShowAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HR_PU");

		EntityManager em = emf.createEntityManager();

		//get all products
//		List<Product>products=em.createQuery("select p from Product p", Product.class)
//				.getResultList();
//		
//		products.forEach(p-> System.out.println(p));
		
		List<ProductDto>productsDtos=em
				.createQuery("select new com.demo.ProductDto(p.name, p.price) from Product p",
				ProductDto.class)
				.getResultList();
		
		productsDtos.forEach(pd-> System.out.println(pd));
		em.close();

		emf.close();
		
	}

}
