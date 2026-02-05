package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.Book;

public interface BookService {
    public List<Book> getAllBooks() ;
    public Book addBook(Book book);
}
