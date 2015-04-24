package com.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student implements Serializable {
	
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
