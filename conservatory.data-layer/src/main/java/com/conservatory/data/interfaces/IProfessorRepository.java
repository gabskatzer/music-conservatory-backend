package com.conservatory.data.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Professor;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Integer>{

	Long deleteByPersonId(Integer personId);
	Optional<Professor> getByPersonId(Integer personId);

}
