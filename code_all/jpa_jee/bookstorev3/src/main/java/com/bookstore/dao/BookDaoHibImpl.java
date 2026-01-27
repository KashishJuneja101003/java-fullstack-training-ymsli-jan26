package com.bookstore.dao;

import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.util.EmFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class BookDaoHibImpl implements BookDao {

	private EntityManagerFactory entityManagerFactory;
	
	
	public BookDaoHibImpl() {
		entityManagerFactory=EmFactory.getEntityManagerFactory();
	}

	@Override
	public List<Book> getAllBooks() {
		EntityManager em=entityManagerFactory.createEntityManager();
		List<Book> books=em.createQuery("select b from Book b", Book.class).getResultList();
		em.close();
		return books;
	}

	@Override
	public Book addBook(Book book) {
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(book);
			tx.commit();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		em.close();
		return book;
	}

}
