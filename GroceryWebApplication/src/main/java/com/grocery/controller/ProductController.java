package com.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grocery.model.Admin;
import com.grocery.model.Category;
import com.grocery.model.Product;
import com.grocery.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	org.slf4j.Logger l=LoggerFactory.getLogger(ProductController.class);
	
	
	@RequestMapping("getallproducts")
	public String getAllProducts(Model m) {
		ps.getAllProd(m);
		return "products";
	}
	
	@RequestMapping("getspecificproducts")
	public String getSpecificProducts(@RequestParam("category") String cat, ModelMap m) {
		System.out.println(cat);
		/*PrintWriter out=req.get*/
		ps.getSpecificProd(cat,m);
		
		return "products";
	}
	
	@RequestMapping("viewallProducts")
	public String ViewProducts(Model m) {
		ps.viewallProduct(m);
		return "viewallproducts";

	}
	
	@RequestMapping("updateProductss")
	public String updateProducts(Product p,@RequestParam("multipartfile") MultipartFile multipartFile,@RequestParam("categoryId")int categoryId) throws IOException, ServletException {
		  if (ps.updateProduct(p,categoryId,multipartFile)) {
			  ps.saveImage(categoryId,multipartFile);
			  //HttpSession ses = req.getSession();
		  //ses.setAttribute("message", "product Added Succesfully...");
			  return "admindashboard"; 
		  }
		 
		return "fail";

	}
	
	@RequestMapping("updateindividualprod")
	public String updateSepProduct() {
		return "updateproducts";

	}
	
	@RequestMapping("getbyprice") 
	  public String getByPrice(Model m) {
	  ps.getByPrice(m);
	  return "products"; 
	  }
	 
	@RequestMapping("getbyname")
	public String getByName(Model m) {
		ps.getByProductName(m);
		return "products";
	}
	
	@RequestMapping("updateProducts")
	public String updateProducts(HttpServletRequest req,Product p) {
		int id=Integer.parseInt(req.getParameter("id"));
	
		ps.updateProduct(id,p);
		return "admindashboard";

	}
	

}
