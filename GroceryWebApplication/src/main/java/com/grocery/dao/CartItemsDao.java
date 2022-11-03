package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.CartItems;

public interface CartItemsDao extends CrudRepository<CartItems, Integer>{

}
