package com.grocery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Payment;

public interface PaymentDao extends CrudRepository<Payment, Integer> {

	List<Payment> findByCustomerCustomerId(int id);

}
