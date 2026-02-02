package com.bookapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public class BookDaoImp implements BookDao {

	private static Map<Integer, Book> books = new HashMap<Integer, Book>();
	static {
		books.put(1, new Book(121, "ABC123", "head first", "katthy", 500.00));
		books.put(1, new Book(11, "ABU123", "head last", "amit", 400.00));
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Book addBook(Book book) {
		book.setId(books.size() + 1);
		books.put(book.getId(), book);
		return book;
	}
}
