package com.lti.project;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@SequenceGenerator(name = "productSeq", initialValue = 9991, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
	@Column(name = "product_id")
	int productId;

	@Column(name = "product_name")
	String productName;

	@Column(name = "product_description")
	String productDescription;

	@Column(name = "product_cost")
	int productCost;

//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	List<Order> order;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

//	public List<Order> getOrder() {
//		return order;
//	}
//
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	

}
