package com.conservatory.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conservatory.business.interfaces.IStudentsService;
import com.conservatory.data.domain.Person;
import com.conservatory.data.domain.Student;
import com.conservatory.data.interfaces.IStudentsRepository;

@Service
public class StudentsService implements IStudentsService{

	@Autowired
	private IStudentsRepository studentsRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentsRepository.findAll();
	}

	public Student createStudent(Student student) {
        return studentsRepository.save(student);
    }

	@Override
	public void deleteStudent(Integer id) {
		studentsRepository.deleteById(id);
		
	}

@Override
public Student updateStudent(Integer id, Student updatedStudent) {
	if(studentsRepository.existsById(id)) {
		updatedStudent.setId(id);
	return studentsRepository.save(updatedStudent);
}else {
	return null;
}
}

@Override
public Optional<Student> getById(Integer id) {
	return studentsRepository.findById(id);
}

	
}
