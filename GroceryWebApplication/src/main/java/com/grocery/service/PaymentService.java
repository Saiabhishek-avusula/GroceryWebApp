package com.grocery.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grocery.dao.CartDao;
import com.grocery.dao.CustomerDao;
import com.grocery.dao.OrderDao;
import com.grocery.dao.PaymentDao;
import com.grocery.exception.StockNotAvailableException;
import com.grocery.model.Cart;
import com.grocery.model.CartItems;
import com.grocery.model.Customer;
import com.grocery.model.Order;
import com.grocery.model.Payment;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao pyd;
	@Autowired
	private CustomerDao cd;
	@Autowired
	private OrderDao od;
	@Autowired
	private CartDao cad;

	public void payementDecisionService(HttpServletRequest req, Payment payment, String pType, Model m) {
		// TODO Auto-generated method stub

		if (pType.equalsIgnoreCase("cards")) {
			HttpSession ses = req.getSession(false);
			System.out.println(ses.getAttribute("user"));
			String name = (String) ses.getAttribute("user");
			Customer customer = cd.findByCustomerUsername(name);
			Order o = new Order();
			o.setCustomer(customer);
			payment.setCustomer(customer);
			payment.setOrder(o);
			List<CartItems> cartitems = customer.getCart().getCartitems();
			int total = 0;
			for (CartItems ci : cartitems) {
				total += ci.getNoItems() * (ci.getProduct().getpPrice()-(ci.getProduct().getpDiscount()*0.01*ci.getProduct().getpPrice()));
			}
			payment.setTotalAmount(total);
			pyd.save(payment);
			m.addAttribute("order", o);
		}

		if (pType.equalsIgnoreCase("cod")) {
			HttpSession ses = req.getSession(false);
			System.out.println(ses.getAttribute("user"));
			String name = (String) ses.getAttribute("user");
			Customer customer = cd.findByCustomerUsername(name);
			Order o = new Order();
			o.setCustomer(customer);
			payment.setCardName("NA");
			payment.setCard("NA");
			payment.setCustomer(customer);
			payment.setOrder(o);
			List<CartItems> cartitems = customer.getCart().getCartitems();
			int total = 0;
			for (CartItems ci : cartitems) {
				total += ci.getNoItems() *(ci.getProduct().getpPrice()-(ci.getProduct().getpDiscount()*0.01*ci.getProduct().getpPrice()));
			}
			payment.setTotalAmount(total);
			pyd.save(payment);
			m.addAttribute("order", o);
		}
	}

	public void vieworders(Model m, HttpServletRequest req) {
		HttpSession ses = req.getSession();

		String name = (String) ses.getAttribute("user");
		Customer customer = cd.findByCustomerUsername(name);
		int id = customer.getCustomerId();
		List<Payment> payment = pyd.findByCustomerCustomerId(id);
		m.addAttribute("order", payment);

	}

	public void stockCheck(HttpServletRequest req) throws StockNotAvailableException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession();
		String name = (String) ses.getAttribute("user");
		Customer customer = cd.findByCustomerUsername(name);
		for (CartItems cartItem : customer.getCart().getCartitems()) {
			if (cartItem.getNoItems() > cartItem.getProduct().getStock()) {
				
				throw new StockNotAvailableException("606",cartItem.getProduct().getpName()+" has stock:- "+cartItem.getProduct().getStock());
			}
		}

	}

	public void getTotal(HttpServletRequest req, Model m) {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession(false);
		System.out.println(ses.getAttribute("user"));
		String name = (String) ses.getAttribute("user");
		Customer customer = cd.findByCustomerUsername(name);
		int cartId = customer.getCart().getCartId();
		/*
		 * int cartItems = customer.getCart().getCartitems().get Iterable<Product>
		 * product = pd.findAllById(cartitem);
		 */
		Cart cart = cad.findById((int) cartId).orElse(new Cart());
		double total = 0;

		for (CartItems cartItem : cart.getCartitems()) {
			total += cartItem.getNoItems() * (cartItem.getProduct().getpPrice()-(cartItem.getProduct().getpDiscount()*0.01*cartItem.getProduct().getpPrice()));
		}
		m.addAttribute("total", total);
		
	}


}
