package com.lti.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.lti.dao.ProjectDao;
import com.lti.project.Card;
import com.lti.project.Customer;
import com.lti.project.Order;
import com.lti.project.Product;

public class ProjectTest {
	ProjectDao dao = new ProjectDao();

	@Test
	public void addACustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("Xyz");
		customer.setPhoneNumber("9876543210");
		customer.setUserName("Xyz");
		customer.setPassword("xyz");
		customer.setSelectBank("SBI");
		customer.setIfscCode("SBIN0001");
		customer.setAccept(false);
		dao.addACustomer(customer);
	}

	@Test
	public void addACard() {
		Card card = new Card();
		card.setCardType("Platinum");
		card.setMaxAmount(40000);
		card.setAmountAvailable(40000);
		Customer customer = dao.findACustomerById(1023);
		if (customer == null) {
			System.out.println("Customer not found");
		} else {
			card.setCustomer(customer);
			customer.setAccept(true);
			dao.addACard(card);
		}
	}

	@Test
	public void viewAllProducts() {
		List<Product> product = dao.viewAllProducts();
		Iterator<Product> items = product.iterator();
		while (items.hasNext()) {
			Product p = items.next();
			System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductDescription() + " "
					+ p.getProductCost());
		}
	}

	@Test
	public void viewAllCard() {
		List<Card> card = dao.viewAllCard();
		Iterator<Card> items = card.iterator();
		while (items.hasNext()) {
			Card c = items.next();
			System.out.println(c.getCardNumber() + " " + c.getCustomer().getCustomerId() + " "
					+ c.getCustomer().getCustomerName() + " " + c.getMaxAmount() + " " + c.getAmountAvailable());
		}
	}

	@Test
	public void addProduct() {
		Product product = new Product();
		product.setProductName("Phone");
		product.setProductDescription("Mi");
		product.setProductCost(10000);
		dao.addAProduct(product);
	}

	@Test
	public void makeOrder() {
		Order orders = new Order();
		Card card = dao.findACard(3002);
		Product p = dao.findAProduct(9994);
		orders.setEmiTimePeriod(4);
		if (card == null) {
			System.out.println("Card doesnot exist");
		} else if (p == null) {
			System.out.println("Product doesnot exist");
		} else if (card.getAmountAvailable() < p.getProductCost()) {
			System.out.println("Product cost is greater than card available amount");
		} else {
			orders.setCardNo(card);
			orders.setProducts(p);
			double cost = (double) orders.getProducts().getProductCost();
			double paid = cost / 4;
			double left = cost - paid;
			orders.setEmiPaid(paid);
			orders.setEmiLeft(left);
			card.setAmountAvailable(card.getAmountAvailable() - p.getProductCost());
			dao.makeOrder(orders);
		}

	}

	@Test
	public void OrderWithCard() {
		Card card = dao.findACard(3002);
		List<Order> or = dao.viewOrderByCard(card);
		Iterator<Order> items = or.iterator();
		while (items.hasNext()) {
			Order o = items.next();
			System.out.println(
					o.getCardNo().getCardNumber() + " " + o.getOrderId() + " " + o.getProducts().getProductName() + " "
							+ o.getProducts().getProductDescription() + " " + o.getEmiPaid() + " " + o.getEmiLeft());
		}

	}
}
