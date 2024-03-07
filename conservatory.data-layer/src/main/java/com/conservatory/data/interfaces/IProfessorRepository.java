package com.conservatory.data.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Professor;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Integer>{

}
