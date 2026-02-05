package com.bookstore.controller;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoHibImpl;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dto.Book;

public class BookStoreController {
	
	public static void main(String[] args) {
		
		BookDao bookDao=new BookDaoHibImpl();
//		
		List<Book> books=bookDao.getAllBooks();
		
		books.forEach(b-> System.out.println(b));
		
//		Book book=bookDao.addBook(new Book("978-9351340201", "effective java", "abc", 340.00));
//		System.out.println(book);
		
	}

}
