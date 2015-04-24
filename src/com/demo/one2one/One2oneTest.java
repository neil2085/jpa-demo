package com.demo.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Table;

import org.junit.Test;

import com.demo.DaoTest;

public class One2oneTest extends DaoTest {

	@Test
	public void testOne2one(){
		
		em.getTransaction().begin();
		
		
		Order order= new Order();
		order.setId(1);
		order.setName("order computer");
		order.setAmount(100d);
		
		Customer c = new Customer();
		c.setId(2);
		c.setName("tom");
		
		//c.setOrder(order);
		order.setCustomer(c);
		
		em.persist(order);
		
		em.getTransaction().commit();
		
	}
	
	@Test
	public void clean(){
		em.getTransaction().begin();
		Query q = em.createQuery("select t from Order t");		
		for(Object o:q.getResultList()){
			em.remove(o);
		}
		em.getTransaction().commit();
	}
	
}

@Entity
@Table(name="customer_order")
class Order{
	@Id
	private Integer id;
	private String name;
	private Double amount;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}

@Entity
class Customer{
	@Id
	private Integer id;
	private String name;
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
