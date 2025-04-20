package com.springbootrest.springbootrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootrest.springbootrest.dao.CategoryDao;
import com.springbootrest.springbootrest.entities.Category;
@Service
public class CategoryServicesImpl implements CategoryServices {
	
  @Autowired	 
  private CategoryDao categoryDao;
	@Override
	public List<Category> getCategorys() {
		
		return categoryDao.findAll();
	}
	
	
	@Override
	public Page<Category> getCategorys(Pageable pageable) {
	    return categoryDao.findAll(pageable);
	}
	
	
	
	@Override
	public Category getCategory(long id) {
	    return categoryDao.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
	}

	@Override
	public Category addCategory(Category category) {
		categoryDao.save(category);
		return category;
	}
	@Override
	public Category updateCategory(Category category) {
		categoryDao.save(category);
		return category;
	}
	@Override
	public void deleteCategory(long id) {
		Category c=categoryDao.getOne(id);
		categoryDao.delete(c);
		
	}

}
