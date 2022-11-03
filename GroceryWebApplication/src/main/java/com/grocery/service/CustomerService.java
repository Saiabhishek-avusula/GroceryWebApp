package com.grocery.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.grocery.dao.CartDao;
import com.grocery.dao.CartItemsDao;
import com.grocery.dao.CategoryDao;
import com.grocery.dao.CustomerDao;
import com.grocery.dao.OrderDao;
import com.grocery.dao.PaymentDao;
import com.grocery.dao.ProductDao;
import com.grocery.dao.ReturnDao;
import com.grocery.model.Cart;
import com.grocery.model.Category;
import com.grocery.model.Customer;
import com.grocery.model.CustomerPrincipal;
import com.grocery.model.Order;
import com.grocery.model.Payment;
import com.grocery.model.Product;
import com.grocery.model.Return;

@Service
public class CustomerService implements UserDetailsService{
	@Autowired
	private CustomerDao cd;
	@Autowired
	private ProductDao pd;
	@Autowired
	private CategoryDao cad;
	@Autowired
	private CartItemsDao cid;
	@Autowired
	private CartDao cartd;
	@Autowired
	private PaymentDao pyd;
	@Autowired
	private ReturnDao returndao;
	@Autowired
	private OrderDao orderdao;
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        // TODO Auto-generated method stub
	        Customer customer=cd.findByCustomerUsername(username);
	        if(customer==null)
	            throw new UsernameNotFoundException("user 404");
	        return new CustomerPrincipal(customer);
	    }


	public Customer customerSignUp(Customer user) {
		Cart c = new Cart();
		user.setCart(cartd.save(c));
		return cd.save(user);

	}

	public int customerLogin(String user, String pass, Model m,HttpServletRequest req) {
		HttpSession ses=req.getSession();
         ses.setAttribute("user",user);
         ses.setMaxInactiveInterval(7*24*60*60);
			 Customer c =cd.findByCustomerUsername(user); 
		if (user.equals(c.getCustomerUsername()) && pass.equals(c.getCustomerPassword())) {
			Iterable<Category> cat = cad.findAll();
			Iterable<Product> prod = pd.findAll();
			m.addAttribute("category", cat);
			m.addAttribute("product", prod);
			return 1;

		}
		return 0;
	}

	public void viewallCustomers(Model m) {
		// TODO Auto-generated method stub
		Iterable<Customer> cust = cd.findAll();
		m.addAttribute("customer", cust);

	}

	public Customer viewCustomer(String cust) {
		// TODO Auto-generated method stub
		return cd.findByCustomerUsername(cust);
	}

	public void updateAdmin(Customer c,Model m) {
		// TODO Auto-generated method stub
		Iterable<Category> cat = cad.findAll();
		Iterable<Product> prod = pd.findAll();
		m.addAttribute("category", cat);
		m.addAttribute("product", prod);
		cd.save(c);
		
	}
	
	public void returnOrder(int id,Model m) {
		Payment payment=pyd.findById(id).get();
		m.addAttribute("payment",payment);
		System.out.println(payment.getOrder().getOrderId());
		
		
	}


	public void returnConfirmService(int id, String rreason,HttpServletRequest req) {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession(false);
		System.out.println(ses.getAttribute("user"));
		String name = (String) ses.getAttribute("user");
		Customer customer = cd.findByCustomerUsername(name);
		Return ret=new Return();
		Payment payment=pyd.findById(id).get();
		ret.setPayment(payment.getOrder());
        ret.setCustomer(customer);
		/* ret.setOrder(customer.getOrders(o.)); */
		ret.setReturnReason(rreason);
		returndao.save(ret);
		
	}
	

	
}

