package com.grocery.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.grocery.controller.AdminController;
import com.grocery.dao.CustomerDao;
import com.grocery.model.Customer;
import com.grocery.service.CartService;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private CartService cas;
	@Autowired
	private CustomerDao customerdao;
	org.slf4j.Logger l=LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(StockNotAvailableException.class)
	public String stockNotAvailableException(StockNotAvailableException stockNotAvailableException, Model m,
			HttpServletRequest req) {
		HttpSession ses = req.getSession();
		String name = (String) ses.getAttribute("user");
		Customer customer = customerdao.findByCustomerUsername(name);
		int id=customer.getCustomerId();
		l.error("you are selecting more than stock,please select again for the customer id:"+" "+id);
		m.addAttribute("errorCode", stockNotAvailableException.getErrorCode());
		System.out.println(stockNotAvailableException.getErrorCode());
		m.addAttribute("errorMessage", stockNotAvailableException.getErrorMessage());
		System.out.println(stockNotAvailableException.getMessage());
		cas.displayCart(req, m);
		return "cart";
	}
}
