package com.conservatory.business.interfaces;

import java.util.List;
import java.util.Optional;

import com.conservatory.data.domain.Student;

public interface IStudentsService {
	
	List<Student> getAllStudents();
	Optional<Student> getById(Integer id);
	Student createStudent(Student student);
	Student updateStudent(Integer id, Student updatedStudent);
	void deleteStudent(Integer id);


}
