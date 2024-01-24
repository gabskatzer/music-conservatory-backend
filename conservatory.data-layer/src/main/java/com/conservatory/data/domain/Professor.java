package com.conservatory.data.domain;
import java.util.List;


public class Professor extends Person{

	private List<Instrument> instruments;

	private List<Class> classes;

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

}
