package com.grocery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grocery.dao.CustomerDao;
import com.grocery.exception.LoginFailException;
import com.grocery.model.Customer;
import com.grocery.service.CustomerService;

@Controller
/* @RequestMapping("/Customer") */
public class CustomerController {
	@Autowired
	private CustomerService cs;
	org.slf4j.Logger l=LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping("Homepage")
	public String customerHomepage() {
		return "indexhome";
	}
	
	
	  @RequestMapping("CustomerLogin")
	  public String customerLogin(Model m,HttpServletRequest req) {
		  HttpSession ses = req.getSession();
			String name = (String) ses.getAttribute("user");
		  l.trace("CUSTOMER LOGIN FAILED");
			l.error("Customer Credentials are invalid for the customer id:");
		  m.addAttribute("custLogin",new Customer());
		  return "customerlogin"; }
	 
	
	@RequestMapping(value = "/customerregister", method =RequestMethod.GET)
	public String customerRegister(Model m) {
		 m.addAttribute("custRegist",new Customer());
		return "customerregister";
	}
	
	@RequestMapping("backtologin")
	public String customerBack() {
		return "customerlogin";
	}
	
	
	
	@RequestMapping("customerSignUp")
	public String customerSignUp( @Valid @ModelAttribute("custRegist") Customer user,BindingResult br) {
		if(br.hasErrors()) {
			return "customerregister";
		}
		System.out.println(user.getCustomerEmail());
		 cs.customerSignUp(user);
		 return "customerlogin";
	}
	
	@ExceptionHandler(value=LoginFailException.class)
	public String loginFailException(Model m) {
		m.addAttribute("message","user Credentials are invalid");
		return "fail";
	}
@RequestMapping("customerLogin")
   public String customerLogin(@Valid @ModelAttribute("custLogin") Customer customer,BindingResult br,@RequestParam(required=false,name="customerUsername") String user,@RequestParam(required=false,name="customerPassword") String pass,HttpServletRequest req, Model m) throws LoginFailException {
	
	if(br.hasErrors()) { 
		  return "customerlogin";
		  }
	int res=cs.customerLogin(user,pass,m,req);
    if(res>0){
          HttpSession ses=req.getSession();
          ses.setAttribute("user",user);
			 ses.setMaxInactiveInterval(7*24*60*60);   
     	   return "products";
     	   
        }
    throw new LoginFailException("user Credentials are invalid"); 

}

@RequestMapping("viewcustomers")
public String viewAllUsers(Model m) {
	cs.viewallCustomers(m);
	return "viewusers";

}


@RequestMapping("logoutpage")
public String Logoutpage(Model m) {
	 m.addAttribute("custLogin",new Customer());
	return "customerlogin";

}

@RequestMapping("viewcustomer")
public String viewAdmin(HttpServletRequest req, Model m) {
	HttpSession ses = req.getSession();
	String cust = (String) ses.getAttribute("user");
	Customer customer = cs.viewCustomer(cust);
	m.addAttribute("customer", customer);
	return "viewcustomer";

}

@RequestMapping("updatecustomer")
public String updatecustomer(Customer c,Model m) {
	cs.updateAdmin(c,m);
	return "products";

}
@RequestMapping("return")
public String Return(HttpServletRequest req,Model m) {
	int id=Integer.parseInt(req.getParameter("id"));
	cs.returnOrder(id,m);
	return "returnpage";
}

@RequestMapping("returnConfirm")
public String returnConfirmCustomer(HttpServletRequest req,@RequestParam("id") int id,@RequestParam("rreason") String rreason) {
	cs.returnConfirmService(id,rreason,req);
	return "returnsuccess";
}

}




/*
 * package com.grocery.controller;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.grocery.model.Customer; import
 * com.grocery.service.CustomerService;
 * 
 * @Controller public class CustomerController {
 * 
 * @Autowired private CustomerService cs;
 * 
 * @RequestMapping("Homepage") public String customerHomepage() { return
 * "indexhome"; }
 * 
 * @RequestMapping("CustomerLogin") public String customerLogin() { return
 * "customerlogin"; }
 * 
 * @RequestMapping("customerregister") public String customerRegister() { return
 * "customerregister"; }
 * 
 * @RequestMapping("backtologin") public String customerBack() { return
 * "customerlogin"; }
 * 
 * 
 * 
 * @RequestMapping("customerSignUp") public String customerSignUp( Customer
 * user) { System.out.println(user.getCustomerEmail()); cs.customerSignUp(user);
 * return "customerlogin"; }
 * 
 * @RequestMapping("customerLogin") public String
 * customerLogin(@RequestParam("customerUsername") String
 * user,@RequestParam("customerPassword") String pass,HttpServletRequest
 * req,Model m) { int res=cs.customerLogin(user,pass,m); if(res>0){ HttpSession
 * ses=req.getSession(); ses.setMaxInactiveInterval(7*24*60*60);
 * ses.setAttribute("user",user); return "products";
 * 
 * } return "fail";
 * 
 * }
 * 
 * @RequestMapping("viewcustomers") public String ViewProducts(Model m) {
 * cs.viewallCustomers(m); return "viewusers";
 * 
 * }
 * 
 * 
 * }
 */