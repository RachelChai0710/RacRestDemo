package com.rac.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rac.rest.demo.data.Customer;

/**
 * Customer Repository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
