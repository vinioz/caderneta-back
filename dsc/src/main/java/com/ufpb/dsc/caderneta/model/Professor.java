package com.ufpb.dsc.caderneta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Professor{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	
	
	public Professor() {}
	

	public int getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}