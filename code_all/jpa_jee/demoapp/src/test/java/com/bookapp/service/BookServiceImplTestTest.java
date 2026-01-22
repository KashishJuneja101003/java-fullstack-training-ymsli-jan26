package com.bookapp.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.dao.BookDao;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTestTest {

	@InjectMocks
	BookServiceImpl bookService; 

	@Mock
	BookDao dao;

	@BeforeEach
	public void before() {
		List<String> allbooks = Arrays.asList("java", "rich dad poor dad", "java adv");
		when(dao.getBooks()).thenReturn(allbooks);
	}

	@Test
	public void getBookTest() {
		System.out.println(dao.getClass());
		List<String> books = bookService.getBooks("java");
		Assertions.assertEquals(2, books.size());
	}

}
