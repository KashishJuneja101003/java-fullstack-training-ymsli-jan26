package com.bookapp.service;

import java.util.List;

import com.bookapp.dao.Book;
import com.bookapp.dao.BookDao;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	
	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		bookDao.addBook(book);
		return book;
	}

}
