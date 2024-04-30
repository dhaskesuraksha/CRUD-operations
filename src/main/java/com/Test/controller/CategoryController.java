package com.Test.controller;

import java.util.List;

import org.apache.el.stream.Optional;
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

import com.Test.model.Category;
import com.Test.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	  @Autowired
	    private CategoryRepository categoryRepository;
	
		@GetMapping("/welcome")
		public String welcome()
		{
			return "Welcome to my Java Machine Test...";
		}
  

	    @GetMapping
	    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(defaultValue = "1") int page,
	                                                           @RequestParam(defaultValue = "10") int size) {
	        List<Category> allCategories = categoryRepository.findAll();
	        List<Category> categories = PaginationUtils.getPage(allCategories, page, size);
	        return new ResponseEntity<>(categories, HttpStatus.OK);
	    }
	    
	    
	    @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        Category createdCategory = categoryRepository.save(category);
	        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
	        java.util.Optional<Category> categoryOptional = categoryRepository.findById(id);
	        
	        if (categoryOptional.isPresent()) {
	            return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategoryById(@PathVariable("id") Long id,
	                                                        @RequestBody Category updatedCategory) {
	        java.util.Optional<Category> categoryOptional = categoryRepository.findById(id);
	        
	        if (categoryOptional.isPresent()) {
	            Category category = categoryOptional.get();
	            category.setName(updatedCategory.getName()); // Assuming we only want to update the name
	            categoryRepository.save(category);
	            return new ResponseEntity<>(category, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	        
	        @DeleteMapping("/{id}")
	        public ResponseEntity<Void> deleteCategoryById(@PathVariable("id") Long id) {
		        java.util.Optional<Category> categoryOptional = categoryRepository.findById(id);
	            
	            if (categoryOptional.isPresent()) {
	                categoryRepository.deleteById(id);
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        }
	    }
	
	