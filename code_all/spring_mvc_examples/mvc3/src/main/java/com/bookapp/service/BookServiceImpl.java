package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.Book;
import com.bookapp.dao.BookDao;
@Service
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	
	@Autowired
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
