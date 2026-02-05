package com.bookapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.dao.BookDao;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
	@InjectMocks
	private BookServiceImpl bookService;
	
	@Mock
	private BookDao bookDao;
	
	@BeforeEach
	public void beforeTest() {
		List<String> books=Arrays.asList("rich dad poor dad","effective java","java adv");
		when(bookDao.getBooks()).thenReturn(books);
	}
	@Test
	void getBooksTest() {
		System.out.println(bookDao.getClass());
		Assertions.assertEquals(2, bookService.getBooks("java"));	
	}
}





