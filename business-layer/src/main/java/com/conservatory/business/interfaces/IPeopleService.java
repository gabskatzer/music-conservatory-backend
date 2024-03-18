package com.conservatory.business.interfaces;

import java.util.List;
import java.util.Optional;

import com.conservatory.business.viewModels.PersonViewModel;
import com.conservatory.data.domain.Person;

public interface IPeopleService {
	
	List<PersonViewModel> getAllPeople();
	Optional<PersonViewModel> getById(Integer id);
	PersonViewModel createPerson(PersonViewModel personViewModel);
	PersonViewModel updatePerson(Integer id, PersonViewModel updatedPerson);
	void deletePerson(Integer id);

}
