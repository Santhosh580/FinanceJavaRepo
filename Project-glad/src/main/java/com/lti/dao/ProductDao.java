package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.project.Product;

public class ProductDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public ProductDao(){
		emf=Persistence.createEntityManagerFactory("pu");
		 em=emf.createEntityManager();
		 tx=em.getTransaction();
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
}
