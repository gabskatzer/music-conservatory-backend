package com.conservatory.business.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
				result.setEmail(professor.get().getPerson().getEmail());
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
				result.setEmail(commissioned.get().getPerson().getEmail());
				result.setPersonId(commissioned.get().getPerson().getPersonId());
				result.setActive(commissioned.get().getPerson().isActive());
				result.setAddress(commissioned.get().getPerson().getAddress());
				result.setOccupation(commissioned.get().getPerson().getOccupation());
				result.setImage(commissioned.get().getPerson().getImage());
				result.setDob(commissioned.get().getPerson().getDob());
				result.setPhone1(commissioned.get().getPerson().getPhone1());
				result.setPhone2(commissioned.get().getPerson().getPhone2());
				result.setCommissioned(true);
			}
			
			return result;
		}).toList();
	}

	@Override
	public PersonViewModel createPerson(PersonViewModel personViewModel) {
		Person person = new Person();
		person.setPersonId(null);
		person.setName(personViewModel.getName());
		person.setOccupation(personViewModel.getOccupation());
		person.setEmail(personViewModel.getEmail());
		person.setImage(personViewModel.getImage());
		person.setDob(personViewModel.getDob());
		person.setPhone1(personViewModel.getPhone1());
		person.setPhone2(personViewModel.getPhone2());
		person.setActive(personViewModel.isActive());
		person.setAddress(personViewModel.getAddress());
		
		if(personViewModel.isStudent()) {
			Student student = new Student();
			student.setType(personViewModel.getStudentType());
			student.setEducationalLevel(personViewModel.getEducationalLevel());
			student.setPerson(person);
			studentRepository.save(student);
		}
		if(personViewModel.isProfessor()) {
			Professor professor = new Professor();
			professor.setPerson(person);
			professorRepository.save(professor);
		}
		if(personViewModel.isCommissioned()) {
			Commissioned comm = new Commissioned();
			comm.setPerson(person);
			comm.setRelationship(personViewModel.getRelationship());
			commissionerRepository.save(comm);
		}
		
		personViewModel.setId(person.getId());

		return personViewModel;
	}

	@Override
	public PersonViewModel updatePerson(Integer id, PersonViewModel viewModel) {
		Optional<Student> student = studentRepository.getByPersonId(id);
		Optional<Professor> professor = professorRepository.getByPersonId(id);
		Optional<Commissioned> comm = commissionerRepository.getByPersonId(id);
		Person person = student.isPresent() ? student.get().getPerson() : professor.isPresent() ? professor.get().getPerson() : comm.get().getPerson();
		
		if(viewModel.isStudent()) {
			
			Student updatedStudent;
			if(student.isPresent()) {
				updatedStudent = student.get();
			}else {
				updatedStudent = new Student();
				updatedStudent.setPerson(person);
			}
			updatedStudent.setType(viewModel.getStudentType());
			updatedStudent.setEducationalLevel(viewModel.getEducationalLevel());
			updatedStudent.getPerson().setActive(viewModel.isActive());
			updatedStudent.getPerson().setAddress(viewModel.getAddress());
			updatedStudent.getPerson().setDob(viewModel.getDob());
			updatedStudent.getPerson().setEmail(viewModel.getEmail());
			updatedStudent.getPerson().setImage(viewModel.getImage());
			updatedStudent.getPerson().setName(viewModel.getName());
			updatedStudent.getPerson().setOccupation(viewModel.getOccupation());
			updatedStudent.getPerson().setPhone1(viewModel.getPhone1());
			updatedStudent.getPerson().setPhone2(viewModel.getPhone2());
			studentRepository.save(updatedStudent);
		}
		else {
			if(student.isPresent()) {
				studentRepository.delete(student.get());
			}
		}
		
		if(viewModel.isProfessor()) {
			Professor updatedProfessor;
			if(professor.isPresent()) {
				updatedProfessor = professor.get();
			}else {
				updatedProfessor = new Professor();
				updatedProfessor.setPerson(person);
			}
			updatedProfessor.getPerson().setActive(viewModel.isActive());
			updatedProfessor.getPerson().setAddress(viewModel.getAddress());
			updatedProfessor.getPerson().setDob(viewModel.getDob());
			updatedProfessor.getPerson().setEmail(viewModel.getEmail());
			updatedProfessor.getPerson().setImage(viewModel.getImage());
			updatedProfessor.getPerson().setName(viewModel.getName());
			updatedProfessor.getPerson().setOccupation(viewModel.getOccupation());
			updatedProfessor.getPerson().setPhone1(viewModel.getPhone1());
			updatedProfessor.getPerson().setPhone2(viewModel.getPhone2());
			professorRepository.save(updatedProfessor);
		}
		else {
			if(professor.isPresent()) {
				professorRepository.delete(professor.get());
			}
		}
		
		if(viewModel.isCommissioned()) {
			Commissioned updatedComm;
			if(comm.isPresent()) {
				updatedComm = comm.get();
			}else {
				updatedComm = new Commissioned();
				updatedComm.setPerson(person);
			}
			updatedComm.getPerson().setActive(viewModel.isActive());
			updatedComm.getPerson().setAddress(viewModel.getAddress());
			updatedComm.getPerson().setDob(viewModel.getDob());
			updatedComm.getPerson().setEmail(viewModel.getEmail());
			updatedComm.getPerson().setImage(viewModel.getImage());
			updatedComm.getPerson().setName(viewModel.getName());
			updatedComm.getPerson().setOccupation(viewModel.getOccupation());
			updatedComm.getPerson().setPhone1(viewModel.getPhone1());
			updatedComm.getPerson().setPhone2(viewModel.getPhone2());
			commissionerRepository.save(updatedComm);
		
		}
		else {
			if(comm.isPresent()) {
				commissionerRepository.delete(comm.get());
			}
		}
		return viewModel;
		
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
			result.setEmail(student.get().getPerson().getEmail());
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
			result.setEmail(professor.get().getPerson().getEmail());
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
			result.setEmail(commissioned.get().getPerson().getEmail());
			result.setPersonId(commissioned.get().getPerson().getPersonId());
			result.setActive(commissioned.get().getPerson().isActive());
			result.setAddress(commissioned.get().getPerson().getAddress());
			result.setOccupation(commissioned.get().getPerson().getOccupation());
			result.setImage(commissioned.get().getPerson().getImage());
			result.setDob(commissioned.get().getPerson().getDob());
			result.setPhone1(commissioned.get().getPerson().getPhone1());
			result.setPhone2(commissioned.get().getPerson().getPhone2());
			result.setCommissioned(true);
		}
		
		return Optional.ofNullable(result);
	}

}
