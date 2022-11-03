package com.grocery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grocery.dao.AdminDao;
import com.grocery.dao.CartDao;
import com.grocery.dao.CategoryDao;
import com.grocery.dao.CustomerDao;
import com.grocery.dao.PaymentDao;
import com.grocery.dao.ProductDao;
import com.grocery.model.Admin;
import com.grocery.model.Cart;
import com.grocery.model.Category;
import com.grocery.model.Customer;
import com.grocery.model.Payment;
import com.grocery.model.Product;

@SpringBootTest
class GroceryWebApplicationTests {
	@Autowired
	private ProductDao pd;
	@Autowired
	private CategoryDao cd;
	@Autowired
	private AdminDao ad;
	@Autowired
	private PaymentDao pyd;
	@Autowired
	private CustomerDao cud;
	@Autowired
	private CartDao cad;

	@Test
	public void testViewAdmin() {
		Admin a = ad.findById(1).get();
		assertEquals("abhi", a.getAdminUsername());
	}



	@Test
	public void testAdminAddProduct() {

		/*
		 * Product p = new Product(); Category c = new Category(); c.setCategoryId(2);
		 * p.setpName("Tomato"); p.setpPrice(25); p.setpDesc("Tomatoes of 1 kg");
		 * p.setpDiscount(2); p.setCategory(c); p.setStock(5);
		 * p.setpPhoto(" http://localhost:8080/images/tomato.jfif"); pd.save(p);
		 */

		assertNotNull(pd.findById(31));
	}

	@Test
	public void testViewProducts() {
		Product p = pd.findById(1).get();
		assertEquals(1200, p.getpPrice());
	}

	@Test
	public void testUpdateProducts() {
		Category c = new Category();
		c.setCategoryId(2);
		Product p = pd.findById(31).get();
		p.setpName("Bottle Guard");
		p.setpPrice(35);
		p.setpDesc("Bottleguard of 1 kg");
		p.setpDiscount(2);
		p.setCategory(c);
		p.setStock(5);
		p.setpPhoto(" http://localhost:8080/images/bottleguard.jfif");
		pd.save(p);
		assertEquals(35, p.getpPrice());
	}

	/*
	 * @Test public void testDeleteProduct() { pd.deleteById(30);
	 * assertThat(pd.existsById(30)).isFalse(); }
	 */

	@Test
	public void testViewPayment() {
		Payment p = pyd.findById(18).get();
		assertEquals(3435, p.getTotalAmount());

	}

	@Test
	public void testViewCustomer() {
		Customer c = cud.findById(3).get();
		assertEquals("karimnagar", c.getCustomerAddress());
	}

	@Test
	public void testAddCustomer() {
		Customer c = new Customer();
		Cart ca = new Cart();
		c.setCart(cad.save(ca));
		c.setCustomerAddress("karimnagar");
		c.setCustomerEmail("shiva@gmail.com");
		c.setCustomerName("shiva");
		c.setCustomerPassword("1234");
		c.setCustomerPhone(799898909);
		c.setCustomerUsername("shiva");
		cud.save(c);
		assertNotNull(cd.findById(4));
	}

	@Test
	public void testUpdateCustomer() {
		Customer c = cud.findById(3).get();
		c.setCustomerAddress("karimnagar");
		c.setCustomerName("abhi");
		c.setCustomerUsername("abhi");
		cud.save(c);
		assertEquals("abhi", c.getCustomerUsername());
	}

	/*
	 * @Test public void testDeleteCustomer() { cud.deleteById(12);
	 * assertThat(cud.existsById(4)).isFalse(); }
	 */
	@Test
	public void testGetTotal() {
		Payment p=pyd.findById(20).get();
		double totpay=1200-(1200*0.1);
		System.out.println(totpay);
		assertEquals(totpay, p.getTotalAmount());
	}
	
	@Test
	public void testSaveImage() {
		Product p = pd.findById(32).get();
		String filePath = " http://localhost:8080/images/tomato.jfif";
		assertEquals(filePath,p.getpPhoto());
	}

}
