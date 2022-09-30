package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer>{

}
