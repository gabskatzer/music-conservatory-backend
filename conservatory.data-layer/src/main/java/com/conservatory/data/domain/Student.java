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
public class Student{
	
//	private Commissioned commissioned;
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
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

	private String type;//regular || becado

	//private List<Instrument> instruments;

//	public Commissioned getCommissioned() {
//		return commissioned;
//	}
//
//	public void setCommissioned(Commissioned commissioned) {
//		this.commissioned = commissioned;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public List<Instrument> getInstruments() {
//		return instruments;
//	}
//
//	public void setInstruments(List<Instrument> instruments) {
//		this.instruments = instruments;
//	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	private String educationalLevel;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
