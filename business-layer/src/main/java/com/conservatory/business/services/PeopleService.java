package com.conservatory.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conservatory.business.interfaces.IPeopleService;
import com.conservatory.data.domain.Person;
import com.conservatory.data.interfaces.IPeopleRepository;

@Service
public class PeopleService implements IPeopleService{

	@Autowired
	private IPeopleRepository peopleRepository;
	
	@Override
	public List<Person> getAllPeople() {
		return peopleRepository.findAll();
	}

	@Override
	public Person findById(Integer id) {
		return peopleRepository.getReferenceById(id);
	}
	
	public Person createPerson(Person person) {
        return peopleRepository.save(person);
    }
	
	public Optional<Person> getPersonById(Integer id) {
		return peopleRepository.findById(id);
	}

	@Override
	public Optional<Person> findByPersonId(Long personId) {
		return peopleRepository.findByPersonId(personId);
	}

	@Override
	public Person updatePerson(Integer id, Person updatedPerson) {
		if(peopleRepository.existsById(id)) {
			updatedPerson.setId(id);
			return peopleRepository.save(updatedPerson);
		}else {
			return null;
		}
	}

	@Override
	public void deletePerson(Integer id) {
		peopleRepository.deleteById(id);
		
	}

	@Override
	public List<Person> getAllProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllCommissioned() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
