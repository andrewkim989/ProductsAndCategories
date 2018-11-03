package com.andrewkim.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewkim.productcategory.models.Category;
import com.andrewkim.productcategory.models.CategoryProduct;
import com.andrewkim.productcategory.models.Product;
import com.andrewkim.productcategory.repositories.CategoryProductRepository;
import com.andrewkim.productcategory.repositories.CategoryRepository;
import com.andrewkim.productcategory.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoryProductRepository productCategoryRepository;
	private final ProductRepository productRepository;
	
	public ProductCategoryService (CategoryRepository categoryRepository,
			CategoryProductRepository productCategoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productCategoryRepository = productCategoryRepository;
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	
	public List<CategoryProduct> allProductCategories() {
		return productCategoryRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        else {
            return null;
        }
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        else {
            return null;
        }
	}
	
	public Category findCategoryName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public Product findProductName(String name) {
		return productRepository.findByName(name);
	}
} 
