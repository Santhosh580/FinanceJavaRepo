package com.lti.project;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order {
	@Id
	@SequenceGenerator(name = "orderSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
	int OrderId;

	@ManyToOne
	@JoinColumn(name = "cardNo")
	Card cardNo;
	int emiTimePeriod;
	double emiPaid;
	public Card getCardNo() {
		return cardNo;
	}

	public void setCardNo(Card cardNo) {
		this.cardNo = cardNo;
	}

	double emiLeft;

	@ManyToOne
	@JoinColumn(name="product_Id")
	Product products;

	public int getOrderId() {
		return OrderId;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	

	public double getEmiPaid() {
		return emiPaid;
	}

	public void setEmiPaid(double emiPaid) {
		this.emiPaid = emiPaid;
	}

	public double getEmiLeft() {
		return emiLeft;
	}

	public void setEmiLeft(double emiLeft) {
		this.emiLeft = emiLeft;
	}

	public int getEmiTimePeriod() {
		return emiTimePeriod;
	}

	public void setEmiTimePeriod(int emiTimePeriod) {
		this.emiTimePeriod = emiTimePeriod;
	}

}
