package com.capgemini.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.obs.entity.BookInfo;
import com.capgemini.obs.entity.Category;
import com.capgemini.obs.entity.CustomerInfo;
import com.capgemini.obs.entity.OrderInfo;
import com.capgemini.obs.exception.OrderException;
import com.capgemini.obs.service.BookService;


public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
			throws OrderException {
		try {
			bookService.addCategory(category);
			return new ResponseEntity<String>("Category added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}

	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@RequestBody BookInfo bookInfo)
			throws OrderException {
		try {
			bookService.addBook(bookInfo);
			return new ResponseEntity<String>("Book added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerInfo customerInfo)
			throws OrderException {
		try {
			bookService.addCustomer(customerInfo);
			return new ResponseEntity<String>("Customer added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrder(@RequestBody OrderInfo orderInfo)
			throws OrderException {
		try {
			bookService.addOrder(orderInfo);
			return new ResponseEntity<String>("Order added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}




}
