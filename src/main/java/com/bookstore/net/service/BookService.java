package com.bookstore.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.net.entity.Books;
import com.bookstore.net.repository.BookRepository;

@Service
public class BookService  {

	@Autowired
	private BookRepository bookRepository;
	
	//To save data from DB
	public void saveMethods(Books books) {
		bookRepository.save(books);
	}
	
	//Get data from DB
	public List<Books> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Books getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteBookId(int id) {
		 bookRepository.deleteById(id);
	}
	
	}
