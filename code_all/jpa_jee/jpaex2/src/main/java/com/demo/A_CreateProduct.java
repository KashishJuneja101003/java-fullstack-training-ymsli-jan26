package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class A_CreateProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

		EntityManager em = emf.createEntityManager();

		// transient object
		Product product = new Product("laptop cover", 500);

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(product);

			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

}
