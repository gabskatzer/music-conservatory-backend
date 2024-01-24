package com.conservatory.data.domain;


public class Grade {

	private int id;

	private Class className;

	private Student student;

	private double grade;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class getClassName() {
		return className;
	}

	public void setClassName(Class className) {
		this.className = className;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	

}
