package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

	Admin findByAdminUsername(String user);

}
