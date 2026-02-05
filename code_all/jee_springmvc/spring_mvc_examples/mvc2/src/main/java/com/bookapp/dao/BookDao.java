package com.bookapp.dao;

import java.util.List;

public interface BookDao{
	public List<Book> getAllBooks();
	public Book addBook(Book book);
}