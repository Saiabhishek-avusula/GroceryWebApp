package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Order;

public interface OrderDao extends CrudRepository<Order, String> {

	
}
