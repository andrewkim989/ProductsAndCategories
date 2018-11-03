package com.andrewkim.productcategory.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewkim.productcategory.models.Category;
import com.andrewkim.productcategory.models.Product;
import com.andrewkim.productcategory.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	private final ProductCategoryService productCategoryService;
	
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/products/new")
	public String createProduct(Model model, @ModelAttribute("product") Product product) {
		model.addAttribute("product", product);
		return "newproduct.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String createCategory(Model model, @ModelAttribute("category") Category category) {
		model.addAttribute("category", category);
		return "newcategory.jsp";
	}
	
	@RequestMapping("/products/new/process")
	public String createProductProcess(@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		}
		else {
			productCategoryService.createProduct(product);
			Long id = product.getId();
			return "redirect:/products/" + id;
		}
	}
	
	@RequestMapping("/categories/new/process")
	public String createCategoryProcess(@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			productCategoryService.createCategory(category);
			Long id = category.getId();
			return "redirect:/categories/" + id;
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct (@PathVariable("id") Long id, Model model) {
		Product product = productCategoryService.findProduct(id);
		model.addAttribute("product", product);
		List<Category> added = product.getCategories();
		model.addAttribute("added", added);
		
		List<Category> categories = productCategoryService.allCategories();
		List<Category> menu = new ArrayList<Category>();
		
		menu.addAll(categories);
		menu.removeAll(added);
		model.addAttribute("menu", menu);
		return "product.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory (@PathVariable("id") Long id, Model model) {
		Category category = productCategoryService.findCategory(id);
		model.addAttribute("category", category);
		List<Product> added = category.getProducts();
		model.addAttribute("added", added);
		
		List<Product> products = productCategoryService.allProducts();
		List<Product> menu = new ArrayList<Product>();
		
		menu.addAll(products);
		menu.removeAll(added);
		model.addAttribute("menu", menu);
		return "category.jsp";
	}
	
	@RequestMapping("/products/{id}/add")
	public String addCategoryToProduct (@PathVariable("id") Long id, HttpServletRequest request) {
		Product product = productCategoryService.findProduct(id);
		String c = request.getParameter("name");
		Category category = productCategoryService.findCategoryName(c);
		product.getCategories().add(category);
		productCategoryService.createProduct(product);
		return "redirect:/products/" + id;
	}
	
	@RequestMapping("/categories/{id}/add")
	public String addProductToCategory (@PathVariable("id") Long id, HttpServletRequest request) {
		Category category = productCategoryService.findCategory(id);
		String p = request.getParameter("name");
		Product product = productCategoryService.findProductName(p);
		category.getProducts().add(product);
		productCategoryService.createCategory(category);
		return "redirect:/categories/" + id;
	}
}
