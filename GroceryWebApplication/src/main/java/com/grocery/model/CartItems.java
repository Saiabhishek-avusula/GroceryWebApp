package com.grocery.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="grocerycartitems")
public class CartItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitemId;
	private int cartId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId",referencedColumnName = "pId")
	private Product product;
	private int noItems;
	
	
	public int getCartitemId() {
		return cartitemId;
	}
	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNoItems() {
		return noItems;
	}
	public void setNoItems(int noItems) {
		this.noItems = noItems;
	}
	
	

}
