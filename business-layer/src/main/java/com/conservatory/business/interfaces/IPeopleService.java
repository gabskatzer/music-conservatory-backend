package com.conservatory.business.interfaces;

import java.util.List;
import java.util.Optional;

import com.conservatory.business.viewModels.PersonViewModel;
import com.conservatory.data.domain.Person;

public interface IPeopleService {
	
	List<PersonViewModel> getAllPeople();
	Optional<Person> getById(Integer id);
	Person createPerson(Person person);
	Person updatePerson(Integer id, Person updatedPerson);
	void deletePerson(Integer id);

}
