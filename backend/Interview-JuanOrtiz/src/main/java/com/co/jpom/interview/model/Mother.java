package com.co.jpom.interview.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



//Children
@Entity
@Table(name="mother")
public class Mother {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fullname;
	private Date birth;
	
	 @OneToMany(mappedBy="mother")
	
	 private List <Person> persons;
	
	
	
	public Mother(long id, String fullname, Date birth, Mother mother) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birth = birth;
	}
	
	public Mother() {
		
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

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
}
