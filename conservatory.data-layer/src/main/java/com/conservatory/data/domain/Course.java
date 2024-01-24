package com.conservatory.data.domain;
import java.util.List;


public class Course {
	
	private int id;
	
	private String name;
	
	private Course requiredCourse;
	
	private Instrument instrument;
	
	private int level;
	
	private List<Class> classes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getRequiredCourse() {
		return requiredCourse;
	}

	public void setRequiredCourse(Course requiredCourse) {
		this.requiredCourse = requiredCourse;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}
