package com.grocery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grocery.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.category.categoryId=?1")
	List<Product> findAllById(int num);
	
	@Query("from Product order by pPrice")
	Iterable<Product> findByOrderByPPrice();
    @Query("from Product order by pName")
	Iterable<Product> sortedPName();


}
