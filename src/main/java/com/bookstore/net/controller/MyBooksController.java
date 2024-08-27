package com.bookstore.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.net.service.MyBookService;

@Controller
public class MyBooksController {
	
	@Autowired
	private MyBookService myBookService;

	@RequestMapping("/deleteMyList/{id}")
	public String deleteById(@PathVariable("id")int id) {
		myBookService.deleteById(id);
		return"redirect:/bk_my";
	}
	
}
