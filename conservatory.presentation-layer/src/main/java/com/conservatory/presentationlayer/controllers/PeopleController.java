package com.conservatory.presentationlayer.controllers;

import java.util.List;
import java.util.Optional;

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
import com.conservatory.business.viewModels.PersonViewModel;
import com.conservatory.data.domain.Person;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
	
	@Autowired
	private IPeopleService peopleService;
	
	@GetMapping
	public List<PersonViewModel> getAllPeople(){
		List<PersonViewModel> people = peopleService.getAllPeople();
		
		return people;

	}
	
	@Transactional
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return peopleService.createPerson(person);
	}
	
	@GetMapping("/{id}")
	public Optional<PersonViewModel> getPersonById(@PathVariable Integer id){
		return peopleService.getById(id);
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
