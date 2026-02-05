package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class C_GetProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HR_PU");

		EntityManager em = emf.createEntityManager();

		
		Product product=em.find(Product.class, 7);
		
		Product product2=new Product();
		
		if(em.contains(product2)) {
			System.out.println("it is there in pc");
		}else {
			System.out.println("it is not in pc");
		}
		
//		em.getTransaction().begin();
//		Product product=em.find(Product.class, 7);
//		System.out.println(product);
//		
//		em.flush(); //bulk insertion in jpa
//		
//		
//		Product product2=em.find(Product.class, 7);
//		System.out.println(product2);
//		
//		em.getTransaction().commit();
		
		em.close();

		emf.close();
	}

}
