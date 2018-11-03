package com.andrewkim.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewkim.productcategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{
	List <Product> findAll();
	Product findByName(String name);
}
