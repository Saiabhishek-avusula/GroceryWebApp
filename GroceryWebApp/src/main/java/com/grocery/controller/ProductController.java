package com.grocery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grocery.model.Admin;
import com.grocery.model.Category;
import com.grocery.model.Product;
import com.grocery.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	
	@RequestMapping("getallproducts")
	public String getAllProducts(Model m) {
		ps.getAllProd(m);
		return "products";
	}
	
	@RequestMapping("getspecificproducts")
	public String getSpecificProducts(@RequestParam("category") String cat, Model m) {
		System.out.println(cat);
		ps.getSpecificProd(cat,m);
		return "products";
	}
	
	@RequestMapping("viewallProducts")
	public String ViewProducts(Model m) {
		ps.viewallProduct(m);
		return "viewallproducts";

	}
	
	@RequestMapping("updateProducts")
	public String updateProducts(Product p) {
		ps.updateProduct(p);
		return "admindashboard";

	}
	
	

}
