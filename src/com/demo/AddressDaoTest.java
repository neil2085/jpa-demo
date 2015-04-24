package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;


public class AddressDaoTest extends DaoTest {


	@Test
	public void query() {
		Query q = em.createQuery("select t from Address t");
	    List<Address> addressList = q.getResultList();
	    for (Address a : addressList) {
	      System.out.println(a.getName());
	    }
	}

	@Test
	public void updateAddress() {
	
		int i=2;
		em.getTransaction().begin();						
		
		Address add = em.find(Address.class, i);
		add.setName(add.getName() + i);
		
		em.getTransaction().commit();
	}
	
	private static void createAddress(int i,EntityManager em) {
		em.getTransaction().begin();				
		
		Address add = new Address();
		add.setId(i);
		add.setName("tom-"+i);
		em.persist(add);
		em.flush();
		
		em.getTransaction().commit();
	}
}
