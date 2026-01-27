package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class D_Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product product=em.find(Product.class, 2);
	
			product.setPrice(720);
			
			//em.merge(product);
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
