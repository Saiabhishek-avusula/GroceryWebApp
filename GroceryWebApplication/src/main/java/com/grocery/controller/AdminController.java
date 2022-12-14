package com.grocery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grocery.dao.CustomerDao;
import com.grocery.exception.LoginFailException;
import com.grocery.model.Admin;
import com.grocery.model.Category;
import com.grocery.model.Customer;
import com.grocery.model.Order;
import com.grocery.model.Product;
import com.grocery.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	org.slf4j.Logger l=LoggerFactory.getLogger(AdminController.class);
	
	@ExceptionHandler(value=LoginFailException.class)
	public String adminLoginFailException(Model m) {
		m.addAttribute("admmessage","Admin Credentials are invalid");
		return "fail1";
	}
	
	
	@RequestMapping("example")
	public String adminLoginRedirect(Model m,HttpServletRequest req) {
		l.trace("ADMIN LOGIN FAILED");
		l.error("Admin Credentials are invalid");
		m.addAttribute("adminLogin",new Admin());
		return "index1";
	}

	@RequestMapping("addProductlink")
	public String example() {
		return "addProducts";
	}
	
	
	@RequestMapping("backtoadminlogin")
	public String LogOut(Model m) {
		m.addAttribute("adminLogin",new Admin());
		return "index1";
	}
	
	
	@RequestMapping("back")
	public String backtoadmindashboard(Model m) {
		as.back(m);
		return "admindashboard";
	}

	// Login of the admin and checking with the database
	@RequestMapping("adminLogin")
	public String adminLogin(@Valid @ModelAttribute("adminLogin") Admin admin,BindingResult br, @RequestParam("adminUsername") String user, @RequestParam("adminPass") String pass,
			HttpServletRequest req,Model m) throws LoginFailException {
		if(br.hasErrors()) {
			return "index1";
		}

		if (as.adminLogin(user, pass,m)) {
			HttpSession ses = req.getSession();
			ses.setAttribute("admin", user);
			
			return "admindashboard";

		}
		throw new LoginFailException("admin Credentials are invalid"); 

	}

	@RequestMapping("viewAdmin")
	public String viewAdmin(HttpServletRequest req, Model m) {
		HttpSession ses = req.getSession();
		String user = (String) ses.getAttribute("admin");
		Admin admin = as.viewAdmin(user);
		m.addAttribute("show", admin);
		return "view";

	}

	@RequestMapping("updateAdmin")
	public String updateAdmin(Admin a) {
		as.updateAdmin(a);
		return "admindashboard";

	}


	// Adding product to the website
	@RequestMapping("uploadProduct")
	public String adminAddProduct(Product p,@RequestParam("multipartfile") MultipartFile multipartFile,@RequestParam("categoryId")int categoryId) throws IOException, ServletException {
		System.out.println(p);
		System.out.println(categoryId);
		
		  if (as.adminAddProd(p,categoryId,multipartFile)) {
			  as.saveImage(categoryId,multipartFile);
			  //HttpSession ses = req.getSession();
		  //ses.setAttribute("message", "product Added Succesfully...");
			  return "admindashboard"; 
		  }
		 
		return "fail";
	}
	
	
	
	
}
