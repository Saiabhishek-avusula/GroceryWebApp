package com.grocery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="groceryCustomer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CustomerId;
	private String CustomerName;
	private String CustomerUsername;
	private int CustomerPhone;
	private String CustomerEmail;
	private String CustomerAddress;
	@OneToMany
    private List<Order> orders=new ArrayList<>();
	
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerUsername() {
		return CustomerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		CustomerUsername = customerUsername;
	}
	public int getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(int customerPhone) {
		CustomerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	
	

}
