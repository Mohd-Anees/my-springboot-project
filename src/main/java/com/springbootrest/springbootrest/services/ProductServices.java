package com.springbootrest.springbootrest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootrest.springbootrest.entities.Product;

public interface ProductServices {
	public List<Product> getProducts();
	Page<Product> getProducts(Pageable pageable); // <-- Add this
	public Product getProduct(long id);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(long id);
	

}
