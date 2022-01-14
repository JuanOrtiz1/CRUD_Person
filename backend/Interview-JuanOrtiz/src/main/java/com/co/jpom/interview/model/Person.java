package com.co.jpom.interview.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//Children
@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fullname;
	private Date birth;
	
	//ForeansKeys
	
	//One Father
	@OneToOne
	@JoinColumn(name="Father_id")
	private Father father;
	
	//One mother
	@OneToOne
	@JoinColumn(name="Mother_id")
	private Mother mother;
	
	public Person(long id, String fullname, Date birth, Father father, Mother mother) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birth = birth;
		this.father = father;
		this.mother = mother;
	}
	
	public Person() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

}
