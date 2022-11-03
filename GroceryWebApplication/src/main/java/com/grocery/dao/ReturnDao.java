package com.grocery.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocery.model.Return;

public interface ReturnDao extends CrudRepository<Return, String> {

}
