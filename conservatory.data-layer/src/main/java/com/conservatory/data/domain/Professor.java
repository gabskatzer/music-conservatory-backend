package com.conservatory.data.domain;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Professor{

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
//	private List<Instrument> instruments;
//
//	private List<Class> classes;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public List<Instrument> getInstruments() {
//		return instruments;
//	}
//
//	public void setInstruments(List<Instrument> instruments) {
//		this.instruments = instruments;
//	}
//
//	public List<Class> getClasses() {
//		return classes;
//	}
//
//	public void setClasses(List<Class> classes) {
//		this.classes = classes;
//	}

}
