package com.springbootrest.springbootrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootrest.springbootrest.dao.ProductDao;
import com.springbootrest.springbootrest.entities.Product;

@Service
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductDao productDao;
	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	
	@Override
	public Page<Product> getProducts(Pageable pageable) {
	    return productDao.findAll(pageable);
	}

	@Override
	public Product getProduct(long id) {
	    return productDao.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		 productDao.save(product);
		 return product;
	}


	@Override
	public void deleteProduct(long id) {
		Product p=productDao.getOne(id);
		productDao.delete(p);
		
	}

}
