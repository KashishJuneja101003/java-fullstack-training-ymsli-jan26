package com.bookapp.service;

import java.util.List;

import com.bookapp.dao.Book;

public interface BookService{
	public List<Book> getAllBooks();
	public Book addBook(Book book);
}