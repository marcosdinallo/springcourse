package com.dinallo.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinallo.spring5webapp.repositories.AuthorRepositorieBean;

@Controller
public class AuthorController {
	
	private AuthorRepositorieBean authorRepoBean;
	
	public AuthorController(AuthorRepositorieBean authorRepoBean) {
		super();
		this.authorRepoBean = authorRepoBean;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepoBean.findAll());
		return "authors";
	}
}
