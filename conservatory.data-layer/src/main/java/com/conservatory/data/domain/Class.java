package com.conservatory.data.domain;


public class Class {
	
	private int id;
	
	private Professor professor;

	private String day;
	
	private String startTime;
	
	private String endTime;
	
	private int classRoom;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private Course course;
	
	private int period;
	
	private int year;

	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

}
