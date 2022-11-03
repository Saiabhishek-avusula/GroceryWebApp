package com.grocery.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.grocery.SequenceGenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name="groceryReturn")
public class Return {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "ret_seq")
    @GenericGenerator(name="ret_seq",
            strategy = "com.grocery.SequenceGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="RET_"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
            }
            )
	private String returnId;
	private String returnReason;
	@OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="order_details")
	private Order payment;
	@ManyToOne
	private Customer customer;
	
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order getPayment() {
		return payment;
	}
	public void setPayment(Order payment) {
		this.payment = payment;
	}
	
	
	

}
