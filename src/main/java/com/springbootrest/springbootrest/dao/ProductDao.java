package com.springbootrest.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.springbootrest.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
