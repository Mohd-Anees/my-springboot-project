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

import com.springbootrest.springbootrest.entities.Category;
import com.springbootrest.springbootrest.services.CategoryServices;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryServices categoryServices;
	
//get all category	
@GetMapping("/category")	
public List<Category> getCategorys(){
	return this.categoryServices.getCategorys();
}

@GetMapping("/categories")
public Page<Category> getCategorys(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size) {
    return this.categoryServices.getCategorys(PageRequest.of(page, size));
}


//get single category
@GetMapping("/category/{id}")
public Category getCategory(@PathVariable String id) {
	return this.categoryServices.getCategory(Long.parseLong(id));
}

//add category
@PostMapping("/category")
public Category addCategory(@RequestBody Category category) {
	return this.categoryServices.addCategory(category);
}

//update category
@PutMapping("/category")
public Category updateCategory(@RequestBody Category category) {
	return this.categoryServices.updateCategory(category);
	
}

//delete the category
@DeleteMapping("/category/{id}")
public ResponseEntity<HttpStatus> deteleCategory(@PathVariable String id){
	try {
		this.categoryServices.deleteCategory(Long.parseLong(id));
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


}
