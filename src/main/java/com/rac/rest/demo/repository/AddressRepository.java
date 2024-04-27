package com.rac.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rac.rest.demo.data.Address;

/**
 * Address Repository
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
