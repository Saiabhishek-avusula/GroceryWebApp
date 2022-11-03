package com.grocery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer> {

	Customer findByCustomerUsername(String user);

}
