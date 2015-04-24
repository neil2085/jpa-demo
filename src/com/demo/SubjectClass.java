package com.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubjectClass
 *
 */
@Entity

public class SubjectClass implements Serializable {
	
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
