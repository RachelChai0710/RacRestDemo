package com.rac.rest.demo.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.rac.rest.demo.data.ErrorResponse;
import com.rac.rest.demo.data.Product;
import com.rac.rest.demo.data.ProductRes;
import com.rac.rest.demo.data.RatingRes;
import com.rac.rest.demo.repository.ProductRepository;
import com.rac.rest.demo.service.ProductService;

/**
 * Controller class for handling product-related HTTP requests.
 * Extends {@link BaseController} to inherit common functionality.
 */
@RestController
@RequestMapping("/prd")
public class ProductController extends BaseController{	
	
	/** The URL of the third-party API to fetch products. */
	private static final String url = "https://fakestoreapi.com/products";
	
	/** Rest Template */
	@Autowired
	private RestTemplate restTemplate;
	
	/** Product Service */
	@Autowired
	ProductService productService;
	
	/**
	 * Sets the logger for this controller.
	 */
	@Override
	protected void setLogger() {
		this.log = LoggerFactory.getLogger(ProductController.class);
		
	}
	
	/**
	 * Retrieves products from a third-party API and adds them to the database.
	 * @return ResponseEntity containing the added products or an error message.
	 */
	@GetMapping("/getNAddAllPrd")
	public ResponseEntity<Object> getNAddAllPrd(){
		ResponseEntity<ProductRes[]> prdResEnt = null;
		List<Product> prds = new ArrayList<>();
		ErrorResponse errRes = null;
		try {
			HttpHeaders headers= new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity <String> entity = new HttpEntity<>(headers);
		    logReqNRes("{}", "3rd Party API Request");
			prdResEnt = restTemplate.exchange(url,HttpMethod.GET, entity ,ProductRes[].class);
			if(null != prdResEnt) {
				logReqNRes(prdResEnt.getBody(), "3rd Party API Response");
				List<ProductRes> prdRes = Arrays.asList(prdResEnt.getBody());
				if(!CollectionUtils.isEmpty(prdRes)) {
					int count = 0;
					for(ProductRes prdDtl: prdRes) {
						RatingRes rating= prdDtl.getRating();
						Product prd = new Product(prdDtl.getTitle(), prdDtl.getPrice(), 
								prdDtl.getDesc(), prdDtl.getCat(), prdDtl.getImg(), 
								rating != null? rating.getRate(): 0, rating != null? rating.getCount(): 0);	
						prds.add(prd);
						count++;
					}
				}
			}
		} catch(RestClientException e){
			this.log.error(e.getMessage());
			errRes = new ErrorResponse(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		} 
		if(null != errRes) {
			return getRes(errRes,  HttpStatus.NOT_FOUND, true);
		}
		List<Product> savedPrds;
		try {
			savedPrds = productService.addAll(prds);
		} catch (Exception e){
			return getRes(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, true);
		}
		
		return getRes(savedPrds, HttpStatus.OK, false);
	}

	/**
	 * Retrieves paginated products from the database.
	 * @param pageNo The page number of products to retrieve.
	 * @return ResponseEntity containing the retrieved products or an error message.
	 */
	@GetMapping("/getAllPrd/{pageNo}")
	public ResponseEntity<Object> getAllPrd(@PathVariable("pageNo") int pageNo) {
		return getRes(productService.findAll(pageNo), HttpStatus.OK, false);
	}
}
