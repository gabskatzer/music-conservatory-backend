package com.conservatory.data.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.conservatory.data.domain.Person;

public interface IPeopleRepository extends JpaRepository<Person, Integer>{

	List<Person> findByName(String name);
	Optional<Person> findByPersonId(Long personId);
}
