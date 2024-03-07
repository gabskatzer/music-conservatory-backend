package com.conservatory.business.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conservatory.business.interfaces.IPeopleService;
import com.conservatory.business.viewModels.PersonViewModel;
import com.conservatory.data.domain.Commissioned;
import com.conservatory.data.domain.Person;
import com.conservatory.data.domain.Professor;
import com.conservatory.data.domain.Student;
import com.conservatory.data.interfaces.ICommissionerRepository;
import com.conservatory.data.interfaces.IProfessorRepository;
import com.conservatory.data.interfaces.IStudentsRepository;

@Service
public class PeopleService implements IPeopleService{

	@Autowired
	private IStudentsRepository studentRepository;
	
	@Autowired
	private IProfessorRepository professorRepository;
	
	@Autowired
	private ICommissionerRepository commissionerRepository;
	
	@Override
	public List<PersonViewModel> getAllPeople() {
		
		Set<Integer> peopleIds = new HashSet<Integer>();
		List<Student> students = studentRepository.findAll();
		
		List<Professor> professors = professorRepository.findAll();
				
		List<Commissioned> commissioneds = commissionerRepository.findAll();
		
		for (Commissioned commissioned : commissioneds) {
			peopleIds.add(commissioned.getPerson().getId());
		}
		
		
		for (Professor professor : professors) {
			peopleIds.add(professor.getPerson().getId());
		}
		
		for (Student student : students) {
			peopleIds.add(student.getPerson().getId());
		}
		
		return peopleIds.stream().map(personId -> {
			PersonViewModel result = new PersonViewModel();
			Optional<Student> student = students.stream().filter(x -> x.getPerson().getId() == personId).findFirst();
			Optional<Professor> professor = professors.stream().filter(x -> x.getPerson().getId() == personId).findFirst();
			Optional<Commissioned> commissioned = commissioneds.stream().filter(x -> x.getPerson().getId() == personId).findFirst();
			
			if(student.isPresent()) {
				result.setId(student.get().getPerson().getId());
				result.setName(student.get().getPerson().getName());
				result.setPersonId(student.get().getPerson().getPersonId());
				result.setActive(student.get().getPerson().isActive());
				result.setStudent(true);
				//todo rest of properties
			}
			if(professor.isPresent()) {
				result.setId(professor.get().getPerson().getId());
				result.setName(professor.get().getPerson().getName());
				result.setPersonId(professor.get().getPerson().getPersonId());
				result.setActive(professor.get().getPerson().isActive());
				result.setProfessor(true);
				//todo rest of properties
			}
			if(commissioned.isPresent()) {
				result.setId(commissioned.get().getPerson().getId());
				result.setName(commissioned.get().getPerson().getName());
				result.setPersonId(commissioned.get().getPerson().getPersonId());
				result.setActive(commissioned.get().getPerson().isActive());
				result.setCommisioned(true);
				//todo rest of properties
			}
			
			return result;
		}).toList();
//		return null;
	}

	@Override
	public Person createPerson(Person person) {
//		return peopleRepository.save(person);
		return null;
	}

	@Override
	public Person updatePerson(Integer id, Person updatedPerson) {
//		if(peopleRepository.existsById(id)) {
//			updatedPerson.setId(id);
//			return peopleRepository.save(updatedPerson);
//		}else {
//			return null;
//		}
		return null;
		
	}

	@Override
	public void deletePerson(Integer id) {
//		peopleRepository.deleteById(id);
		
		
	}

	@Override
	public Optional<Person> getById(Integer id) {
//		return peopleRepository.findById(id);
		return null;
	}

}
