package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class E_Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Product product=em.find(Product.class, 3);
			if(product!=null) {
				em.remove(product);
			}
			
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
