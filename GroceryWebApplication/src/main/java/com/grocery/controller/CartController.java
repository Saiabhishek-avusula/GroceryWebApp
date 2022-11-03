package com.grocery.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grocery.exception.StockNotAvailableException;
import com.grocery.model.Cart;
import com.grocery.service.CartService;
import com.grocery.service.CustomerService;
@Controller
public class CartController {
	@Autowired
	private CustomerService cs;
	@Autowired
	private CartService cas;
	
	
	@RequestMapping("addtocart")
	public String addToCart(HttpServletRequest req,@RequestParam("product") int pId,@RequestParam("quantity") int quantity,Model m) {
		System.out.println(pId+" "+quantity);
		 Cart cart=cas.addToCart(req,pId,quantity,m); 
		m.addAttribute("status",1);
		
		return "products";
		
	}
	
	@RequestMapping("backtoproducts")
	public String BackToProducts(Model m) {
		cas.backProd(m);
		return "products";
		
	}
	
	@RequestMapping("displaycart")
	public String DisplayCart(HttpServletRequest req, Model m) {
		cas.displayCart(req,m);
		return "cart";
		
	}
	
	@RequestMapping("removeProduct")
	public void removeProduct(@RequestParam("cartItemId") int cartItemId) {
		System.out.println("In cart Controler");
		cas.removeProduct(cartItemId);
	}

	
	

}
