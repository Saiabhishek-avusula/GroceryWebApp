package com.grocery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.grocery.SequenceGenerator.*;

@Entity
@Table(name="groceryOrder")
public class Order {
	@Id
	/* @GeneratedValue(strategy = GenerationType.IDENTITY) */
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "ord_seq")
    @GenericGenerator(name="ord_seq",
            strategy = "com.grocery.SequenceGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="ORD_"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
            }
            )
	private String OrderId;
	@ManyToOne()
	private Customer customer;

	
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
