package com.conservatory.data.domain;
import java.util.List;

public class Instrument {

	private int id;

	private String name;

	private boolean individual;

	private List<Student> students;

	private List<Professor> professors;

	private List<Course> courses;

	public Instrument() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
