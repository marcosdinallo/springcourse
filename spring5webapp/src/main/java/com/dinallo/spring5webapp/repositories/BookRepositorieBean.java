package com.dinallo.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dinallo.spring5webapp.models.Book;

public interface BookRepositorieBean extends CrudRepository<Book, Long>{

}
