package com.bookstore.net.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.net.entity.Books;
import com.bookstore.net.entity.MyBooks;
import com.bookstore.net.service.BookService;
import com.bookstore.net.service.MyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/bk_register")
	public String bookRegister() {
		return "bookregister";
	}
	
	@GetMapping("/bk_my")
	public String getMyBook(Model model) {
		List<MyBooks> listMyBook=myBookService.getMyBooksList();
		model.addAttribute("mybooks",listMyBook);
		return "mybook";
	}
	
	@RequestMapping("/my_bk/{id}")
	public String getMyBook(@PathVariable("id") int id) {
		Books books=bookService.getBookById(id);
		MyBooks myBooks=new MyBooks(books.getId(),books.getBookName(),books.getAuthor(),books.getPrice());
		myBookService.saveMyBook(myBooks);
		return "redirect:/bk_my";
	}
	
	
//	  @GetMapping("/bk_available") 
//	  public String bookAvailable() { 
//		  return "bookavailable";
//		  }
	 
	@GetMapping("/bk_available")
	public ModelAndView getBookAll() {
		List<Books> list=bookService.getAllBooks();
		//ModelAndView modelAndView=new ModelAndView();
		//modelAndView.setViewName("bookavailable"); 
		//modelAndView.addObject("books",list);
		 return new ModelAndView("bookavailable","books",list);
	}
	
//	@GetMapping("/bk_store")
//	public String bookStore() {
//		return "bookStore";
//	}
	
	//post methods
	@PostMapping("/save")
	public String addbook(@ModelAttribute Books books) {
		bookService.saveMethods(books);
		return "redirect:/bk_available";
	}
	
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Books bookedit=bookService.getBookById(id);
		model.addAttribute("eBook", bookedit);
		return "bookEdit";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteBookId(id);
		return "redirect:/bk_available";
    }
}
