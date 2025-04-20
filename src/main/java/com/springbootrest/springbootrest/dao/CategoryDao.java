package com.springbootrest.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.springbootrest.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}

