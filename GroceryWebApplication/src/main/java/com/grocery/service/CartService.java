package com.grocery.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.grocery.dao.CartDao;
import com.grocery.dao.CartItemsDao;
import com.grocery.dao.CategoryDao;
import com.grocery.dao.CustomerDao;
import com.grocery.dao.ProductDao;
import com.grocery.model.Cart;
import com.grocery.model.CartItems;
import com.grocery.model.Category;
import com.grocery.model.Customer;
import com.grocery.model.Product;

@Service
public class CartService {
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
	
	public Cart addToCart(HttpServletRequest req, int pId, int quantity, Model m) {
		HttpSession ses = req.getSession(false);
		System.out.println(ses.getAttribute("user"));
		String name = (String) ses.getAttribute("user");
		Customer customer = cd.findByCustomerUsername(name);

		int cartId = customer.getCart().getCartId();
		CartItems cartitem = new CartItems();
		cartitem.setCartId(cartId);

		cartitem.setNoItems(quantity);

		Product prod = new Product();
		prod.setpId(pId);

		cartitem.setProduct(pd.findById(pId).orElse(new Product()));
		Cart cart = cartd.findById((int) cartId).orElse(new Cart());

		for (CartItems cartItem : cart.getCartitems()) {
//			System.out.println(cartItem);
//			System.out.println("cartId:"+cartId+" productId:"+pId);
			
			if (cartItem.getCartId() == (cartId) && cartItem.getProduct().getpId()==(pId)) {
				
				cartitem.setCartitemId(cartItem.getCartitemId());
			}
		}

		cid.save(cartitem);
		Iterable<Category> cat = cad.findAll();
		Iterable<Product> product = pd.findAll();
		m.addAttribute("category", cat);
		m.addAttribute("product", product);
		return cartd.findById((int) cartId).orElse(new Cart());

	}

	public void displayCart(HttpServletRequest req, Model m) {
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
		Cart cart = cartd.findById((int) cartId).orElse(new Cart());
		double total = 0;

		for (CartItems cartItem : cart.getCartitems()) {
			total += cartItem.getNoItems() * (cartItem.getProduct().getpPrice()-(cartItem.getProduct().getpDiscount()*0.01*cartItem.getProduct().getpPrice()));
		}
        m.addAttribute("customer",customer);
		m.addAttribute("cartitems", cart.getCartitems());
		m.addAttribute("total", total);

	}

	public void removeProduct(int cartItemId) {
		// TODO Auto-generated method stub
		System.out.println("In servie");
		cid.deleteById(cartItemId);
		
		
	}

	public void backProd(Model m) {
		// TODO Auto-generated method stub
		Iterable<Category> cat = cad.findAll();
		Iterable<Product> prod = pd.findAll();
		m.addAttribute("category", cat);
		m.addAttribute("product", prod);
	}


}
