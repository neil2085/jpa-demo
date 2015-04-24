package com.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Test;

public class Many2oneTest extends DaoTest {

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
	public void clean(){
		em.getTransaction().begin();
		Query q = em.createQuery("select t from Student t");		
		for(Object o:q.getResultList()){
			em.remove(o);
		}
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

@Entity

class Student implements Serializable {
	
	@Id
	private Integer studentId;
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_class", 
	joinColumns={@JoinColumn(name="sid",referencedColumnName="studentId")},
	inverseJoinColumns={@JoinColumn(name="cid",referencedColumnName="classId")})
	private List<SubjectClass> classes;
	
	
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubjectClass> getClasses() {
		if(classes == null) this.classes = new ArrayList<SubjectClass>();
		return classes;
	}

	public void setClasses(List<SubjectClass> classes) {
		this.classes = classes;
	}
   
	
	
}


@Entity

class SubjectClass implements Serializable {
	
	@Id
	private Integer classId;
	private String name;
	
	@ManyToMany(mappedBy="classes",cascade = CascadeType.ALL)
	private List<Student> students;
	
	private static final long serialVersionUID = 1L;

	public SubjectClass() {
		super();
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		if(this.students==null) this.students = new ArrayList<Student>();
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
   
	
	
}