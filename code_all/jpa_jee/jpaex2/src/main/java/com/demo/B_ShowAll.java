package com.demo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class B_ShowAll {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

		EntityManager em = emf.createEntityManager();

		//ORM: i talk in object and walk in object
		//SQL vs HQL / JPQL
		//get all products
//		List<Product>products=em.createQuery("select p from Product p", Product.class)
//				.getResultList();
//		
	//	products.forEach(p-> System.out.println(p));
		
//		List<Object[]>products=em.createQuery("select p.id, p.price from Product p", Object[].class)
//				.getResultList();
//		for(Object[] o: products) {
//			System.out.println(o[0]+": "+o[1]);
//		}
		
		//We want not to write that comp code 
		
		List<ProductDto> dtos=em.createQuery("select new com.demo.ProductDto(p.name, p.price) from Product p", 
				ProductDto.class).getResultList();
		
		
		
	}

}









