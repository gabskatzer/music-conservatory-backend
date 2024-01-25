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

import com.conservatory.business.interfaces.IPeopleService;
import com.conservatory.data.domain.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
	
	@Autowired
	private IPeopleService peopleService;

	@GetMapping
    public List<Person> getAllPeople() {
		List<Person> people = peopleService.getAllPeople();
		
        return people;
    }
	
	@PostMapping
    public Person createPerson(@RequestBody Person person) {

        return peopleService.createPerson(person);
    }
	
	@GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Integer id) {
        return peopleService.getPersonById(id);
    }
	
	@GetMapping("/search")
    public Optional<Person> getPersonByPersonId(Long personId) {
        return peopleService.findByPersonId(personId);
    }
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Integer id, @RequestBody Person updatedPerson) {
		return peopleService.updatePerson(id, updatedPerson);
	}
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Integer id) {
		peopleService.deletePerson(id);
	}
}

