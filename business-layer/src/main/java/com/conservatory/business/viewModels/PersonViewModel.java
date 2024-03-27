package com.conservatory.business.viewModels;

import java.util.Date;


public class PersonViewModel {

	private int id;
	
	private String name;
	
	private Long personId;
	
	private boolean active;
	
	private String email;
	
	private String address;
	
	private String occupation;
	
	private String image;
	
	private Date dob;
	
	private Long phone1;
	
	private Long phone2;
	
	private String relationship;
	
	private String educationalLevel;
	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	private String studentType;
	private boolean isStudent;
	private boolean isProfessor;
	private boolean isCommissioned;
	

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	public boolean isProfessor() {
		return isProfessor;
	}

	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

	public boolean isCommissioned() {
		return isCommissioned;
	}

	public void setCommissioned(boolean isCommissioned) {
		this.isCommissioned = isCommissioned;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPhone1() {
		return phone1;
	}

	public void setPhone1(Long phone1) {
		this.phone1 = phone1;
	}

	public Long getPhone2() {
		return phone2;
	}

	public void setPhone2(Long phone2) {
		this.phone2 = phone2;
	}
}
