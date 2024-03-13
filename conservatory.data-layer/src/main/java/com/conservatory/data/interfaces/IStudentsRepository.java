package com.conservatory.data.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.conservatory.data.domain.Student;

@Repository
public interface IStudentsRepository extends JpaRepository<Student, Integer>{

	Long deleteByPersonId(Integer personId);
	Optional<Student> getByPersonId(Integer personId);
}
