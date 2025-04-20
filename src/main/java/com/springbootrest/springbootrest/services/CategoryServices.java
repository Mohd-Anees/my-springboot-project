package com.springbootrest.springbootrest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootrest.springbootrest.entities.Category;

public interface CategoryServices {
public List<Category> getCategorys();
Page<Category> getCategorys(Pageable pageable); // <-- Add this
public Category getCategory(long id);
public Category addCategory(Category category);
public Category updateCategory(Category category);
public void deleteCategory(long id);
}
