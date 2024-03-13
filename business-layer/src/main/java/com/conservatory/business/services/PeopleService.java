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
import com.conservatory.data.interfaces.IPersonRepository;
import com.conservatory.data.interfaces.IProfessorRepository;
import com.conservatory.data.interfaces.IStudentsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PeopleService implements IPeopleService{

	@Autowired
	private IStudentsRepository studentRepository;
	
	@Autowired
	private IProfessorRepository professorRepository;
	
	@Autowired
	private ICommissionerRepository commissionerRepository;
	
	@Autowired
	private IPersonRepository personRepository;
	
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
				result.setAddress(student.get().getPerson().getAddress());
				result.setOccupation(student.get().getPerson().getOccupation());
				result.setImage(student.get().getPerson().getImage());
				result.setDob(student.get().getPerson().getDob());
				result.setPhone1(student.get().getPerson().getPhone1());
				result.setPhone2(student.get().getPerson().getPhone2());
				result.setStudentType(student.get().getType());
				result.setStudent(true);
			}
			if(professor.isPresent()) {
				result.setId(professor.get().getPerson().getId());
				result.setName(professor.get().getPerson().getName());
				result.setPersonId(professor.get().getPerson().getPersonId());
				result.setActive(professor.get().getPerson().isActive());
				result.setAddress(professor.get().getPerson().getAddress());
				result.setOccupation(professor.get().getPerson().getOccupation());
				result.setImage(professor.get().getPerson().getImage());
				result.setDob(professor.get().getPerson().getDob());
				result.setPhone1(professor.get().getPerson().getPhone1());
				result.setPhone2(professor.get().getPerson().getPhone2());
				result.setProfessor(true);
			}
			if(commissioned.isPresent()) {
				result.setId(commissioned.get().getPerson().getId());
				result.setName(commissioned.get().getPerson().getName());
				result.setPersonId(commissioned.get().getPerson().getPersonId());
				result.setActive(commissioned.get().getPerson().isActive());
				result.setAddress(commissioned.get().getPerson().getAddress());
				result.setOccupation(commissioned.get().getPerson().getOccupation());
				result.setImage(commissioned.get().getPerson().getImage());
				result.setDob(commissioned.get().getPerson().getDob());
				result.setPhone1(commissioned.get().getPerson().getPhone1());
				result.setPhone2(commissioned.get().getPerson().getPhone2());
				result.setCommisioned(true);
			}
			
			return result;
		}).toList();
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
		studentRepository.deleteByPersonId(id);
		commissionerRepository.deleteByPersonId(id);
		professorRepository.deleteByPersonId(id);
		personRepository.deleteById(id);
		
	}

	@Override
	public Optional<PersonViewModel> getById(Integer id) {
		Optional<Student> student = studentRepository.getByPersonId(id);
		Optional<Professor> professor = professorRepository.getByPersonId(id);
		Optional<Commissioned> commissioned = commissionerRepository.getByPersonId(id);
		
		PersonViewModel result = new PersonViewModel();
		
		if(student.isPresent()) {
			result.setId(student.get().getPerson().getId());
			result.setName(student.get().getPerson().getName());
			result.setPersonId(student.get().getPerson().getPersonId());
			result.setActive(student.get().getPerson().isActive());
			result.setAddress(student.get().getPerson().getAddress());
			result.setOccupation(student.get().getPerson().getOccupation());
			result.setImage(student.get().getPerson().getImage());
			result.setDob(student.get().getPerson().getDob());
			result.setPhone1(student.get().getPerson().getPhone1());
			result.setPhone2(student.get().getPerson().getPhone2());
			result.setStudentType(student.get().getType());
			result.setStudent(true);
		}
		if(professor.isPresent()) {
			result.setId(professor.get().getPerson().getId());
			result.setName(professor.get().getPerson().getName());
			result.setPersonId(professor.get().getPerson().getPersonId());
			result.setActive(professor.get().getPerson().isActive());
			result.setAddress(professor.get().getPerson().getAddress());
			result.setOccupation(professor.get().getPerson().getOccupation());
			result.setImage(professor.get().getPerson().getImage());
			result.setDob(professor.get().getPerson().getDob());
			result.setPhone1(professor.get().getPerson().getPhone1());
			result.setPhone2(professor.get().getPerson().getPhone2());
			result.setProfessor(true);
		}
		if(commissioned.isPresent()) {
			result.setId(commissioned.get().getPerson().getId());
			result.setName(commissioned.get().getPerson().getName());
			result.setPersonId(commissioned.get().getPerson().getPersonId());
			result.setActive(commissioned.get().getPerson().isActive());
			result.setAddress(commissioned.get().getPerson().getAddress());
			result.setOccupation(commissioned.get().getPerson().getOccupation());
			result.setImage(commissioned.get().getPerson().getImage());
			result.setDob(commissioned.get().getPerson().getDob());
			result.setPhone1(commissioned.get().getPerson().getPhone1());
			result.setPhone2(commissioned.get().getPerson().getPhone2());
			result.setCommisioned(true);
		}
		
		return Optional.ofNullable(result);
	}

}
