package com.demo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table(catalog = "PUBLIC", schema = "PUBLIC")
public class Address implements Serializable {

	
	@Id
	private Integer id;
	private String name;
	
	@Version
	private Integer version;
	
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
