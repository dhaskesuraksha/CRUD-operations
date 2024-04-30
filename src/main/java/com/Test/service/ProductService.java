package com.Test.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Test.model.Product;
import com.Test.repository.CategoryRepository;
import com.Test.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.getContent();
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            return null;
        }
    }


    public Product updateProductById(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    
    
    public boolean deleteProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}


