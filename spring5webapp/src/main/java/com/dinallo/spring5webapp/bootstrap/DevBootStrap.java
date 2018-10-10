package com.dinallo.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dinallo.spring5webapp.models.Author;
import com.dinallo.spring5webapp.models.Book;
import com.dinallo.spring5webapp.models.Publisher;
import com.dinallo.spring5webapp.repositories.AuthorRepositorieBean;
import com.dinallo.spring5webapp.repositories.BookRepositorieBean;
import com.dinallo.spring5webapp.repositories.PublisherRepositorieBean;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepositorieBean authorRepositorie;
	private BookRepositorieBean bookRepositorie;
	private PublisherRepositorieBean publisherRepoBean;
	
	public DevBootStrap(AuthorRepositorieBean authorRepositorie, BookRepositorieBean bookRepositorie, PublisherRepositorieBean publisherRepoBean) {
		this.authorRepositorie = authorRepositorie;
		this.bookRepositorie = bookRepositorie;
		this.publisherRepoBean = publisherRepoBean;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	/**
	 * method to initialize objects to store in database
	 * */
	private void initData() {
		
		//Creating publisher object
		Publisher publi = new Publisher("Abril", "Merchants Quay");
		
		//Saving publisher
		publisherRepoBean.save(publi);
		
		//Creating first author and book
		Author aut1 = new Author("Marcos", "Di Nallo");
		Book book1 = new Book("Lord of the Rings", "AB1122298097", publi);
		aut1.getBooks().add(book1);
		book1.getAuthors().add(aut1);
		
		//Saving first author and book
		authorRepositorie.save(aut1);
		bookRepositorie.save(book1);
		
		//Creating second author and book
		Author author2 = new Author("Gláucia", "D'Epiro");
		Book book2 = new Book("Game of Thrones", "CCABF636354", publi);
		author2.getBooks().add(book2);
		
		//Saving second author
		authorRepositorie.save(author2);
		bookRepositorie.save(book2);
		
	}

}
