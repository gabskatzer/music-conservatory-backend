package com.conservatory.data.domain;
import java.util.List;

public class Student extends Person{

	private Commissioned commissioned;

	private String type;

	private List<Instrument> instruments;

	public Commissioned getCommissioned() {
		return commissioned;
	}

	public void setCommissioned(Commissioned commissioned) {
		this.commissioned = commissioned;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

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
