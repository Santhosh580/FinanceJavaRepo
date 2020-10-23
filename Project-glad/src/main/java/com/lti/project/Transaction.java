package com.lti.project;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_transaction")
public class Transaction {
	@Id
	@SequenceGenerator(name = "transSeq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transSeq")

	int transaction_id;

	@ManyToOne
	@JoinColumn(name = "card_number")
	Card card;
	@OneToMany(mappedBy = "transaction")
	List<Order> order;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}

}

	
	
