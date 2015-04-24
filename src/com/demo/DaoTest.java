package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;

public class DaoTest {
	private static final String PERSISTENCE_UNIT_NAME = "testjpa";
	private static EntityManagerFactory factory;
	protected static EntityManager em;

	@BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);		
		em = factory.createEntityManager();	
	}
}
