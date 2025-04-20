package com.springbootrest.springbootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.springbootrest.entities.Product;
import com.springbootrest.springbootrest.services.ProductServices;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	
	//get all the products
	@GetMapping("/product")
	public List<Product> getProducts(){
		return this.productServices.getProducts(); 
	}
	//get pagination
	@GetMapping("/products")
	public Page<Product> getProducts(
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "5") int size) {
	    return this.productServices.getProducts(PageRequest.of(page, size));
	}
	
	
	
	//get single products
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		return this.productServices.getProduct(Long.parseLong(id));
	}
	
	//add the products
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product ) {
		return this.productServices.addProduct(product);
	}
	
	//update the products
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return this.productServices.updateProduct(product);
	}
	//delete the products
	@DeleteMapping("product/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id){
		try {
			this.productServices.deleteProduct(Long.parseLong(id));
			return new ResponseEntity <>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	

}
