package com.lti.project;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_card")
public class Card {

	@Id
	@SequenceGenerator(name="cardSeq",initialValue=3001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cardSeq")
	int cardNumber;
	String cardType;
	double maxAmount;
	double amountAvailable;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
//	@OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
//	List<Order> order;
	
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public double getAmountAvailable() {
		return amountAvailable;
	}

	public void setAmountAvailable(double amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public List<Order> getOrder() {
//		return order;
//	}
//
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}
	

}
