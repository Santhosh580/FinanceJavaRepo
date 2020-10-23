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
		customer.setCustomerName("ABC");
		customer.setPhoneNumber("9090909");
		customer.setUserName("ABC");
		customer.setPassword("aaa");
		customer.setSelectBank("SBI");
		customer.setIfscCode("SBIIB1212");
		customer.setAccept(true);
		dao.addACustomer(customer);
	}
	
	public void addACard(){
		Card card = new Card();
		card.setCardType("Platinum");
		card.setMaxAmount(40000);
		card.setAmountAvailable(40000);
		Customer customer = dao.findACustomerById(1007); 
		card.setCustomer(customer);
		dao.addACard(card);
	}
	
	@Test
	public void viewAllProducts() {
	List<Product> product = dao.viewAllProducts();
	Iterator<Product> items = product.iterator();
	while (items.hasNext()) {
	Product p = items.next();
	System.out.println(p.getProductName()+" "+p.getProductDescription()+" "+p.getProductCost());
	}
	}
	@Test
	public void addProduct(){
		Product product = new Product();
		product.setProductName("Laptop");
		product.setProductDescription("Made in India");
		product.setProductCost(40000);
	}
	
	
	@Test
	public void makeOrder() {  
        Order orders=new Order();
        //orders.setCardNo(1001);
        //Product p=dao.findAProduct(1001);
        //orders.setProducts();
        orders.setEmiTimePeriod(4);
        double paid=(double)orders.getProducts().getProductCost()/4;
        double left;
        orders.setEmiPaid(paid);
        //orders.setEmiLeft(left);
       
    }
	@Test
	   public void OrderWithCard() {
	       // List<Order> or = dao.viewOrderBy("1001");
	       // Iterator<Order> items = or.iterator();
	       // while (items.hasNext()) {
	         //   Order o = items.next();
	           // System.out.println(o.getCardNo()+" "+o.getOrderId()+" "+o.getProducts()+" "+o.getEmiPaid()+" "o.getEmiLeft());
	    }

}
