package com.productapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@Value("${PRODUCT_NOT_FOUND_MESSAGE}")
	private String errorMessage404;
	
	@Value("${INTERNAL_SERVER_ERROR_MESSAGE}")
	private String errorMessage500;
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorInfo> handle500(Exception e) {
//		ErrorInfo errorInfo=new ErrorInfo(errorMessage500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
//				"it@yamlsi.com", LocalDateTime.now());
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//	}
//	
	//ProductNotFoundException
	
	
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException e) {
		String errorMessage= e.getBindingResult()
				.getAllErrors()
				.stream()
				.map(ex-> ex.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		ErrorInfo errorInfo=new ErrorInfo(errorMessage, HttpStatus.BAD_REQUEST.toString(),
				"it@yamlsi.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
	
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException e) {
		ErrorInfo errorInfo=new ErrorInfo(e.getMessage(), HttpStatus.NOT_FOUND.toString(),
				"it@yamlsi.com", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<String> handle404(ProductNotFoundException e) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
}
