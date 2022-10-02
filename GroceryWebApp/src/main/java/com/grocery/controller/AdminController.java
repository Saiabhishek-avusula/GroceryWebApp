package com.grocery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grocery.model.Admin;
import com.grocery.model.Category;
import com.grocery.model.Product;
import com.grocery.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;

	@RequestMapping("addProductlink")
	public String example() {
		return "addProducts";
	}
	
	@RequestMapping("back")
	public String backtoadmindashboard() {
		return "admindashboard";
	}

	// Login of the admin and checking with the database
	@RequestMapping("adminLogin")
	public String adminLogin(@RequestParam("adminUsername") String user, @RequestParam("adminPass") String pass,
			HttpServletRequest req) {

		if (as.adminLogin(user, pass)) {
			HttpSession ses = req.getSession();
			ses.setAttribute("admin", user);
			return "admindashboard";

		}
		return "fail";

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
/*
 * @RequestParam("pName") String pName, @RequestParam("pDesc") String pDesc,
 * 
 * @RequestParam("pPrice") int pPrice, @RequestParam("pDiscount") int pDiscount,
 * 
 * @RequestParam("catId") int catid, HttpServletRequest req
 */
