package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class C_GetProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

		EntityManager em = emf.createEntityManager();
		//Lazy loading and eager featching
	
		Product product1=em.find(Product.class, 2); //1st level cache
		
		em.detach(product1);
		
		Product product2=em.find(Product.class, 2);
	
		
//		Product product=em.find(Product.class, 2);
//		System.out.println("----$$$$$$$$$$$$$$----");
//		System.out.println(product.getId());
//		//LazyInitializationException
//		em.close();
//		System.out.println("----------------");
//		System.out.println(product.getName());
		
		
		
		
//		Product product=em.getReference(Product.class, 2);
//		System.out.println("----$$$$$$$$$$$$$$----");
//		System.out.println(product.getId());
//		//LazyInitializationException
//		em.close();
//		System.out.println("----------------");
//		System.out.println(product.getName());
//		
		em.close();
		emf.close();
		
		System.out.println("hello");
	
	}

}
