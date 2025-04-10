package com.dunkin.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunkin.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
