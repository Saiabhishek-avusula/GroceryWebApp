package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Category;

public interface CategoryDao extends CrudRepository<Category, Integer> {

}
