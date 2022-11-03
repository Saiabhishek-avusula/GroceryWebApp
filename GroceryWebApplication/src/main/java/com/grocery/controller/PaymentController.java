package com.grocery.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grocery.exception.StockNotAvailableException;
import com.grocery.model.Payment;
import com.grocery.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	private PaymentService pys;
	
	@RequestMapping("paymentcontrol")
	public String PaymentPage(HttpServletRequest request,Model m) throws StockNotAvailableException {
		
		pys.stockCheck(request);
		pys.getTotal(request,m);
		
		return "paymentpage";
	}
	
	@RequestMapping("paymentdecision")
	public String paymentDecision(HttpServletRequest req,Payment payment,@RequestParam("paymentType") String pType,Model m) {
		pys.payementDecisionService(req,payment,pType,m);
		
		return "successfulpage";
		
	}
	
	@RequestMapping("viewuserorders")
	public String viewOrders(Model m,HttpServletRequest req) {
		pys.vieworders(m,req);
		return "vieworders";
	}
	
	

}
