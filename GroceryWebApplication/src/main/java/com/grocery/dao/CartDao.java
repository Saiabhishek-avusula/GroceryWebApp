package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Cart;

public interface CartDao extends CrudRepository<Cart, Integer>{

}
