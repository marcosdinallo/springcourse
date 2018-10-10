package com.dinallo.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dinallo.spring5webapp.models.Author;

public interface AuthorRepositorieBean extends CrudRepository<Author, Long>{

}
