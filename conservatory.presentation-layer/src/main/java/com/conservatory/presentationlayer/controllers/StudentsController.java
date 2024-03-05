package com.conservatory.presentationlayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conservatory.business.interfaces.IStudentsService;
import com.conservatory.data.domain.Person;
import com.conservatory.data.domain.Student;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
	
	@Autowired
	private IStudentsService studentsService;

	@GetMapping
    public List<Student> getAllStudents() {
		List<Student> people = studentsService.getAllStudents();
		
        return people;
    }
	@Transactional
	@PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentsService.createStudent(student);
    }
	
	@GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        return studentsService.getById(id);
    }
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
		return studentsService.updateStudent(id, updatedStudent);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentsService.deleteStudent(id);
	}
}

