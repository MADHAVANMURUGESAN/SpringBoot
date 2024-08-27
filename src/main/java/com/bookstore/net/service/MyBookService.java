package com.bookstore.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.net.entity.MyBooks;
import com.bookstore.net.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepository myBookRepository;
	
	public void saveMyBook(MyBooks books) {
		myBookRepository.save(books);
	}
	
	public List<MyBooks> getMyBooksList(){
		return myBookRepository.findAll();
	}
	
	public void deleteById(int id) {
		myBookRepository.deleteById(id);
	}
}
