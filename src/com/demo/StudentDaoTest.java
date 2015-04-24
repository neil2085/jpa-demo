package com.demo;

import junit.framework.Assert;

import org.junit.Test;

public class StudentDaoTest extends DaoTest {

	@Test
	public void insert(){
		em.getTransaction().begin();
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setName("tom");
		SubjectClass c1 =new SubjectClass();
		c1.setClassId(2);
		c1.setName("math");
		s1.getClasses().add(c1);
		c1.getStudents().add(s1);
		em.persist(s1);
		em.flush();
		em.getTransaction().commit();
	}
	
	@Test
	public void deleteClass(){
		em.getTransaction().begin();
		Student s1 = em.find(Student.class, 1);
		s1.getClasses().clear();
		em.flush();
		em.getTransaction().commit();
	}
	
	@Test
	public void addClassAddress(){
		em.getTransaction().begin();
		Student s1 = em.find(Student.class, 1);
		
		Address ad = new Address();
		ad.setId(6);
		ad.setName("100 front stree 6");
		s1.getAddresses().add(ad);
		
		ad.setStudent(s1); //have to set student, otherwise the sid is empty
		
		em.persist(s1);
		em.flush();
		em.getTransaction().commit();
	}
	
	@Test
	public void addStudent(){
		em.getTransaction().begin();
		Student s1 = em.find(Student.class, 1);
		SubjectClass c2 = new SubjectClass();
		c2.setClassId(7);
		c2.setName("computer7");
		
		s1.getClasses().add(c2);
		
		em.persist(c2);
		em.flush();
		em.getTransaction().commit();
		
		System.out.println(c2.getStudents().size() + " >>>>>");
	}
	
	@Test
	public void findClass(){
		SubjectClass sc = em.find(SubjectClass.class, 7);
		Assert.assertEquals(1, sc.getStudents().size());
	}
}
