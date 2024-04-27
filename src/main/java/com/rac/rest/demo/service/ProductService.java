package com.rac.rest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rac.rest.demo.data.Product;
import com.rac.rest.demo.repository.ProductRepository;

/**
 * Service class for managing product-related operations.
 */
@Service
public class ProductService {
	
	/** Product Repository */
	@Autowired
	ProductRepository prdRepository;
	
	/**
	 * Adds a list of products to the database.
	 * @param prds The list of products to add.
	 * @return The list of added products.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Product> addAll(List<Product> prds){
		return prdRepository.saveAll(prds);
	}
	
	/**
	 * Retrieves a page of products from the database.
	 * @param pageNo The page number to retrieve.
	 * @return The page of products.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Page<Product> findAll(int pageNo){
		return prdRepository.findAll(PageRequest.of(pageNo, 10));
	}
}
