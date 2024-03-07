package com.conservatory.data.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Person;
import com.conservatory.data.domain.Student;

@Repository
public interface IStudentsRepository extends JpaRepository<Student, Integer>{

//	List<Student> findByName(String name);
}
