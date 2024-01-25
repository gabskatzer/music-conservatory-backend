package com.conservatory.business.interfaces;

import java.util.List;
import java.util.Optional;

import com.conservatory.data.domain.Person;

public interface IPeopleService {
	
	List<Person> getAllPeople();
	Person findById(Integer id);
	Person createPerson(Person person);
	Optional<Person> getPersonById(Integer id);
	Optional<Person> findByPersonId(Long personId);
	Person updatePerson(Integer id, Person updatedPerson);
	void deletePerson(Integer id);

}
