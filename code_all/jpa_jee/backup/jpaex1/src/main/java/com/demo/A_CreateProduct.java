package com.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class A_CreateProduct {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HR_PU");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Product product = new Product("kb", 420);

		em.persist(product);
	

		em.getTransaction().commit();

		em.close();

		emf.close();
	}

}
