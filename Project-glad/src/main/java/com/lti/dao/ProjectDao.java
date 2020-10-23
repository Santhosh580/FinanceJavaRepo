package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.project.Card;
import com.lti.project.Customer;
import com.lti.project.Order;
import com.lti.project.Product;

public class ProjectDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public ProjectDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void addACustomer(Customer customer){
		tx.begin();
		em.merge(customer);
		tx.commit();
		System.out.println("Added Customer");
	}
	
	public void addACard(Card card){
		tx.begin();
		em.merge(card);
		tx.commit();
		System.out.println("Added Card");
	}
	public Customer findACustomerById(int id){
		return em.find(Customer.class, id);
	}
	
	public void addAProduct(Product product){
		  tx.begin();
		  em.merge(product);
		  tx.commit();
		  em.close();
	}
	
	public List<Product> viewAllProducts(){
		Query query = em.createQuery("select p from Product p", Product.class);
		return query.getResultList();
		}
	
	public void makeOrder(Order orders) {
        tx.begin();
        em.merge(orders);
        tx.commit();
    }
    public List<Order> viewOrderBy(Card cardNo) {
        String jpql="select o from Order o where o.cardNo=cn";
        Query query = em.createQuery(jpql,Order.class);
        query.setParameter("cn",cardNo);
        return query.getResultList();
    }
    public Product findAProduct(int productId) {
        return em.find(Product.class, productId);
    }
	
}
