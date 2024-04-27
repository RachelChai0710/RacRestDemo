package com.rac.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rac.rest.demo.data.Product;

/**
 * Product Repository
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
}
