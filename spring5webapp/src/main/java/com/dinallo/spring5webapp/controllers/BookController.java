package com.dinallo.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinallo.spring5webapp.repositories.BookRepositorieBean;

@Controller
public class BookController {
	
	private BookRepositorieBean bookRepositorieBean;
	
	

	public BookController(BookRepositorieBean bookRepositorieBean) {
		this.bookRepositorieBean = bookRepositorieBean;
	}



	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepositorieBean.findAll());
		return "books";
	}
}
